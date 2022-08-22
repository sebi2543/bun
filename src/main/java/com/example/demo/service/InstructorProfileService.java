package com.example.demo.service;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.InstructorProfile;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface InstructorProfileService {
    Optional<List<InstructorProfile>>findAll();
    Optional<InstructorProfile>findById(IdentificationProfileDTO identificationProfileDTO);
    List<InstructorProfile>getAll();
    InstructorProfile getById(IdentificationProfileDTO identificationProfileDTO);
    InstructorProfile save(InstructorProfile instructorProfile);
    void delete(InstructorProfile instructorProfile);
    void checkId(IdentificationProfileDTO identificationProfileDTO);
    void checkInstructorProfile(BasicInstructorProfileDTO basicInstructorProfileDTO);

}
