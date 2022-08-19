package com.example.demo.service;

import com.example.demo.dto.InstructorProfileDTOId;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.repository.InstructorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorProfileImpl implements InstructorProfileService{

    @Autowired
    InstructorProfileRepository instructorProfileRepository;

    @Override
    public Optional<List<InstructorProfile>> findAll() {
        return Optional.of(instructorProfileRepository.findAll());
    }

    @Override
    public Optional<InstructorProfile> findById(InstructorProfileDTOId instructorProfileDTOId) {
        return instructorProfileRepository.findById(instructorProfileDTOId.getId());
    }

    @Override
    public List<InstructorProfile> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    @Override
    public InstructorProfile getById(InstructorProfileDTOId instructorProfileDTOId) {
       return this.findById(instructorProfileDTOId).orElseThrow(InvalidParameterException::new);
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
    public void checkId(InstructorProfileDTOId instructorProfileDTOId) {
        Optional<InstructorProfile>instructorProfile=instructorProfileRepository.findById(instructorProfileDTOId.getId());
        if (instructorProfile.isEmpty()) {
            throw new InvalidParameterException();
        }

    }
}
