package com.example.demo.service;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorMapper instructorMapper;

    public void save(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public List<Instructor> showAll(){
         return  instructorRepository.findAll();
    }

    public void delete(Instructor instructor){
        instructorRepository.delete(instructor);
    }

    public Optional<Instructor> findById(int id){
        return instructorRepository.findById((long) id);
    }

    public void addCourse(Course course,Instructor instructor) throws  InvalidDataAccessApiUsageException {
        Optional<Instructor> instructorOptional = instructorRepository.findById(instructor.getId());
        if (instructorOptional.isPresent()) {
            course.setInstructor(instructorOptional.get());
            courseRepository.save(course);
        }
    }
   public  ArrayList<Instructor> findByFullName(Instructor instructor){
       return instructorRepository.findByFirstNameAndLastName(instructor.getFirstName(),instructor.getLastName());
   }

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

