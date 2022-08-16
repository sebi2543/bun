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

    void save(Instructor instructor);
    List<Instructor> showAll();
    void delete(Instructor instructor);
    Optional<Instructor> findById(int id);
    void addCourse(Course course, Instructor instructor);
    ArrayList<Instructor> findByFullName(Instructor instructor);
    void checkInstructor(Instructor instructor) throws InvalidName;
}
