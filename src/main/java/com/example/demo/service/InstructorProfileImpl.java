package com.example.demo.service;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.exception.InvalidInstructorProfileId;
import com.example.demo.exception.InvalidLikedIn;
import com.example.demo.exception.InvalidYoutube;
import com.example.demo.repository.InstructorProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorProfileImpl implements InstructorProfileService{


    final InstructorProfileRepository instructorProfileRepository;

    @Override
    public Optional<List<InstructorProfile>> findAll() {
        return Optional.of(instructorProfileRepository.findAll());
    }

    @Override
    public Optional<InstructorProfile> findById(IdentificationProfileDTO identificationProfileDTO) {
        return instructorProfileRepository.findById(identificationProfileDTO.getId());
    }

    @Override
    public List<InstructorProfile> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    @Override
    public InstructorProfile getById(IdentificationProfileDTO identificationProfileDTO) {
       return this.findById(identificationProfileDTO).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public InstructorProfile save(InstructorProfile instructorProfile) {
        return instructorProfileRepository.save(instructorProfile);
    }

    @Override
    public void delete(InstructorProfile instructorProfile) {
        instructorProfileRepository.delete(instructorProfile);
    }

    @Override
    public void checkId(IdentificationProfileDTO identificationProfileDTO) {
        Optional<InstructorProfile>instructorProfile=instructorProfileRepository.findById(identificationProfileDTO.getId());
        if (instructorProfile.isEmpty()) {
            throw new InvalidInstructorProfileId();
        }

    }

    @Override
    public void checkInstructorProfile(BasicInstructorProfileDTO basicInstructorProfileDTO) {
        if (basicInstructorProfileDTO.getLinkedin().length()==0)
            throw new InvalidLikedIn();
        if (basicInstructorProfileDTO.getYoutube().length()==0)
            throw new InvalidYoutube();
    }
}
