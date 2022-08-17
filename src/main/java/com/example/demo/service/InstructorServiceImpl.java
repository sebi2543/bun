package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.dto.InstructorDTOId;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository instructorRepository;

    public void save(Instructor instructor){
        instructorRepository.save(instructor);
    }

    @Override
    public void checkInstructor(InstructorDTO instructor) throws InvalidName {
        if (instructor.getLastName().length()==0 || instructor.getFirstName().length()==0)
            throw new InvalidName();
    }

    public Optional<List<Instructor>>findAll(){
       return  Optional.of(instructorRepository.findAll());
    }

    public Optional<Instructor>findById(InstructorDTOId instructor){
        return  instructorRepository.findById(instructor.getId());
    }

    public Optional<List<Instructor>>findByFullName(InstructorDTO instructor){
        return instructorRepository.findByFirstNameAndLastName(instructor.getFirstName(),instructor.getLastName());
    }

    public List<Instructor>getAll(){
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Instructor getById(InstructorDTOId instructor){
        return this.findById(instructor).orElseThrow(InvalidParameterException::new);
    }

    public List<Instructor>getByFullName(InstructorDTO instructor){
        return this.findByFullName(instructor).orElseThrow(InvalidParameterException::new);
    }
}

