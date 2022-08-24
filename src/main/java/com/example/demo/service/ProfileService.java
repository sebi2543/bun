package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProfileService {
    Optional<List<Profile>>findAll();
    Optional<Profile>findById(IdentificationProfileDTO identificationProfileDTO);
    List<Profile>getAll();
    Profile getById(IdentificationProfileDTO identificationProfileDTO);
    Profile save(Profile profile);
    void delete(IdentificationProfileDTO identificationProfileDTO);
    void checkId(IdentificationProfileDTO identificationProfileDTO);
    void checkInstructorProfile(BasicProfileDTO basicProfileDTO);
    void update(IdentificationProfileDTO identificationProfileDTO, BasicProfileDTO basicProfileDTO);
    void add(BasicProfileDTO basicProfileDTO);
}
