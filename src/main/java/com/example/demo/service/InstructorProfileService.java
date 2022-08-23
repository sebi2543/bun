package com.example.demo.service;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationInstructorProfileDTO;
import com.example.demo.entity.InstructorProfile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorProfileService {
    Optional<List<InstructorProfile>>findAll();
    Optional<InstructorProfile>findById(IdentificationInstructorProfileDTO identificationInstructorProfileDTO);
    List<InstructorProfile>getAll();
    InstructorProfile getById(IdentificationInstructorProfileDTO identificationInstructorProfileDTO);
    InstructorProfile save(InstructorProfile instructorProfile);
    void delete(IdentificationInstructorProfileDTO identificationInstructorProfileDTO);
    void checkId(IdentificationInstructorProfileDTO identificationInstructorProfileDTO);
    void checkInstructorProfile(BasicInstructorProfileDTO basicInstructorProfileDTO);
    void update(IdentificationInstructorProfileDTO identificationInstructorProfileDTO, BasicInstructorProfileDTO basicInstructorProfileDTO);
    void add(BasicInstructorProfileDTO basicInstructorProfileDTO);
}
