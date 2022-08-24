package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.Profile;
import com.example.demo.exception.InvalidInstructorProfileId;
import com.example.demo.exception.InvalidLikedIn;
import com.example.demo.exception.InvalidYoutube;
import com.example.demo.mapper.ProfileMapper;
import com.example.demo.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileImpl implements ProfileService {


    final ProfileRepository profileRepository;
    final ProfileMapper instructorProfileMapper;

    @Override
    public Optional<List<Profile>> findAll() {
        return Optional.of(profileRepository.findAll());
    }

    @Override
    public Optional<Profile> findById(IdentificationProfileDTO identificationProfileDTO) {
        return profileRepository.findById(identificationProfileDTO.getId());
    }

    @Override
    public List<Profile> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    @Override
    public Profile getById(IdentificationProfileDTO identificationProfileDTO) {
       return this.findById(identificationProfileDTO).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(IdentificationProfileDTO identificationProfileDTO) {
        Profile profile =this.getById(identificationProfileDTO);
        profileRepository.delete(profile);
    }

    @Override
    public void checkId(IdentificationProfileDTO identificationProfileDTO) {
        Optional<Profile>instructorProfile= profileRepository.findById(identificationProfileDTO.getId());
        if (instructorProfile.isEmpty()) {
            throw new InvalidInstructorProfileId();
        }

    }

    @Override
    public void checkInstructorProfile(BasicProfileDTO basicProfileDTO) {
        if (basicProfileDTO.getLinkedin().length()==0)
            throw new InvalidLikedIn();
        if (basicProfileDTO.getYoutube().length()==0)
            throw new InvalidYoutube();
    }

    @Override
    public void update(IdentificationProfileDTO identificationProfileDTO, BasicProfileDTO basicProfileDTO) {
        Profile profile =this.getById(identificationProfileDTO);
        profile.setYoutube(basicProfileDTO.getYoutube());
        profile.setLinkedin(basicProfileDTO.getLinkedin());
        profileRepository.save(profile);
    }

    @Override
    public void add(BasicProfileDTO basicProfileDTO) {
        Profile profile =instructorProfileMapper.toEntity(basicProfileDTO);
        profileRepository.save(profile);
    }

}
