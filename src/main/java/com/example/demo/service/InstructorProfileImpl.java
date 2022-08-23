package com.example.demo.service;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationInstructorProfileDTO;
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
    public Optional<InstructorProfile> findById(IdentificationInstructorProfileDTO identificationInstructorProfileDTO) {
        return instructorProfileRepository.findById(identificationInstructorProfileDTO.getId());
    }

    @Override
    public List<InstructorProfile> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    @Override
    public InstructorProfile getById(IdentificationInstructorProfileDTO identificationInstructorProfileDTO) {
       return this.findById(identificationInstructorProfileDTO).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public InstructorProfile save(InstructorProfile instructorProfile) {
        return instructorProfileRepository.save(instructorProfile);
    }

    @Override
    public void delete(IdentificationInstructorProfileDTO identificationInstructorProfileDTO) {
        InstructorProfile instructorProfile=this.getById(identificationInstructorProfileDTO);
        instructorProfileRepository.delete(instructorProfile);
    }

    @Override
    public void checkId(IdentificationInstructorProfileDTO identificationInstructorProfileDTO) {
        Optional<InstructorProfile>instructorProfile=instructorProfileRepository.findById(identificationInstructorProfileDTO.getId());
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

    @Override
    public void update(IdentificationInstructorProfileDTO identificationInstructorProfileDTO, BasicInstructorProfileDTO basicInstructorProfileDTO) {
        InstructorProfile instructorProfile=this.getById(identificationInstructorProfileDTO);
        instructorProfile.setYoutube(basicInstructorProfileDTO.getYoutube());
        instructorProfile.setLinkedin(basicInstructorProfileDTO.getLinkedin());
        instructorProfileRepository.save(instructorProfile);
    }

}
