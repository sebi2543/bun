package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
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

    private List<Profile> findAll() {
        return (profileRepository.findAll());
    }

    private Optional<Profile> findById(long profileId) {
        return profileRepository.findById(profileId);
    }

    @Override
    public List<Profile> getAll() {
        return this.findAll();
    }

    @Override
    public Profile getById(long profileId) {
       return this.findById(profileId).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public Profile save(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public void delete(long profileId) {
        Profile profile =this.getById(profileId);
        profileRepository.delete(profile);
    }

    @Override
    public void update(long profileId, BasicProfileDTO basicProfileDTO) {
        Profile profile =this.getById(profileId);
        profile.setYoutube(basicProfileDTO.getYoutube());
        profile.setLinkedin(basicProfileDTO.getLinkedin());
        this.save(profile);
    }

    @Override
    public void add(BasicProfileDTO basicProfileDTO) {
        Profile profile =instructorProfileMapper.toEntity(basicProfileDTO);
        this.save(profile);
    }
}
