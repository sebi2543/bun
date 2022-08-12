package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InstructorService {

    void checkInstructor(Instructor instructor) throws InvalidName;
    List<InstructorDTO> InstructorsToDTOS(List<Instructor> instructors);
}
