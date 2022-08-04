package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Getter
@Setter
@AllArgsConstructor
@ToString
public class InstructorRepositoryServiceImpl implements InstructorRepositoryService{

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    CourseRepository courseRepository;

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

    public void populateDataBase() {
        List<Instructor> courses = Arrays.asList(
                new Instructor("JOHN", "MILNER", new InstructorProfile("milnerlinkedin", "milneryoutub")),
                new Instructor("HARRY", "MILNER", new InstructorProfile("harrylinkedin", "harryyoutub")),
                new Instructor("JOHN", "SMITH", new InstructorProfile("johnlinkedin", "johnyoutub")));
        instructorRepository.saveAll(courses);
    }

}

