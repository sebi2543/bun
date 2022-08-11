package com.example.demo.service;

import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import org.springframework.stereotype.Service;

@Service
public interface InstructorService {
    void checkInstructor(Instructor instructor) throws InvalidName;
}
