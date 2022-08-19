package com.example.demo.service;

import com.example.demo.dto.InstructorProfileDTOId;
import com.example.demo.entity.InstructorProfile;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface InstructorProfileService {
    Optional<List<InstructorProfile>>findAll();
    Optional<InstructorProfile>findById(InstructorProfileDTOId instructorProfileDTOId);
    List<InstructorProfile>getAll();
    InstructorProfile getById(InstructorProfileDTOId instructorProfileDTOId);
    InstructorProfile save(InstructorProfile instructorProfile);
    void delete(InstructorProfile instructorProfile);
    void checkId(InstructorProfileDTOId instructorProfileDTOId);

}
