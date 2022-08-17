package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public interface InstructorService {
    List<Instructor> getAll();
    Instructor getById(int id);
    List<Instructor> getByFullName(InstructorDTO instructor);
    Optional<List<Instructor>>findAll();
    Optional<Instructor> findById(int id);
    Optional<List<Instructor>>findByFullName(InstructorDTO instructor);
    void checkInstructor(InstructorDTO instructor) throws InvalidName;
    void save(Instructor instructor);
}
