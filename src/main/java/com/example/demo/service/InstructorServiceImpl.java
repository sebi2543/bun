package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import com.example.demo.mapper.InstructorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    InstructorRepositoryService instructorRepositoryService;

    @Autowired
    InstructorMapper instructorMapper;
    @Override
    public void checkInstructor(Instructor instructor) throws InvalidName {
        if (instructor.getLastName().length()==0 || instructor.getFirstName().length()==0)
            throw new InvalidName();
    }

    @Override
    public List<InstructorDTO> InstructorsToDTOS(List<Instructor> instructors) {
        List<InstructorDTO> instructorDTOs = new ArrayList<>();
        for (Instructor instructor : instructors)
            instructorDTOs.add(instructorMapper.InstructorToDTO(instructor));
        return instructorDTOs;
    }

}
