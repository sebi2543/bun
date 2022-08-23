package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorService {

    List<Instructor> getAll();
    Instructor getById(IdentificationInstructorDTO instructor);
    List<Instructor> getByFullName(BasicInstructorDTO instructor);
    Optional<List<Instructor>>findAll();
    Optional<Instructor> findById(IdentificationInstructorDTO instructor);
    Optional<List<Instructor>>findByFullName(BasicInstructorDTO instructor);
    List<Instructor>getAllOrderByRating();
    void checkInstructor(BasicInstructorDTO instructor);
    void save(Instructor instructor);
    void delete(Instructor instructor);
    void checkId(IdentificationInstructorDTO identificationInstructorDTO);
    public void assignProfile(IdentificationInstructorDTO identificationInstructorDTO, IdentificationProfileDTO identificationProfileDTO);
    void assignCourse(IdentificationInstructorDTO identificationInstructorDTO, IdentificationCourseDTO identificationCourseDTO);
}
