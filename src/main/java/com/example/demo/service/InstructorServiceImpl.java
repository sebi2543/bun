package com.example.demo.service;

import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InstructorRepositoryService instructorRepositoryService;
    @Override
    public void checkInstructor(Instructor instructor) throws InvalidName {
        if (instructor.getLastName().length()==0 || instructor.getFirstName().length()==0)
            throw new InvalidName();
    }
}
