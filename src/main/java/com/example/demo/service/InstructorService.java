package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    public void insertInstructor(Instructor instructor){
          instructorRepository.save(instructor);
    }

    public void showInstructors(){
        List<Instructor> instructors = instructorRepository.findAll();
        for (Instructor instructor : instructors)
            System.out.println(instructor);
    }

    public ArrayList<Instructor> selectTheBestInstructors(){
        return instructorRepository.selectTheBestInstructors();
    }

    public void save(Instructor instructor){
        instructorRepository.save(instructor);
    }

    public void show(){
        System.out.println(instructorRepository.findAll());
    }
    public ArrayList<Instructor> findBy(String firstName,String lastName){
        return instructorRepository. findByFirstnameOrLastname(firstName,lastName);
    }





}
