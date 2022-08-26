package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface ProfileService {
    Optional<List<Profile>>findAll();
    Optional<Profile>findById(long profileId);
    List<Profile>getAll();
    Profile getById(long profileId);
    Profile save(Profile profile);
    void delete(long profileId);
    void update(long profileId, BasicProfileDTO basicProfileDTO);
    void add(BasicProfileDTO basicProfileDTO);
}
