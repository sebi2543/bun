package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorService {

    List<Instructor> getAll();
    Instructor getById(long instructorId);
    List<Instructor> getByFullName(BasicInstructorDTO instructor);
    Optional<List<Instructor>>findAll();
    Optional<Instructor> findById(long instructorId);
    Optional<List<Instructor>>findByFullName(BasicInstructorDTO instructor);
    List<Instructor>getAllOrderByRating();
    void save(Instructor instructor);
    void delete(long instructorId);
    void assignProfile(long instructorId,long profileId);
    void assignCourse(long instructorId,long courseId);
    void update(long instructorId,BasicInstructorDTO basicInstructorDTO);
    void add(BasicInstructorDTO basicInstructorDTO);
}
