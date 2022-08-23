package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.dto.IdentificationInstructorProfileDTO;
import com.example.demo.entity.Instructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    void delete(IdentificationInstructorDTO identificationInstructorDTO);
    void checkId(IdentificationInstructorDTO identificationInstructorDTO);
    void assignProfile(IdentificationInstructorDTO identificationInstructorDTO, IdentificationInstructorProfileDTO identificationInstructorProfileDTO);
    void assignCourse(IdentificationInstructorDTO identificationInstructorDTO, IdentificationCourseDTO identificationCourseDTO);
    void update(IdentificationInstructorDTO identificationInstructorDTO,BasicInstructorDTO basicInstructorDTO);
    void add(BasicInstructorDTO basicInstructorDTO);
}
