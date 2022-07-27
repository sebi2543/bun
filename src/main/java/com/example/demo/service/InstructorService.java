package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void  findById(int id){
        Instructor instructor=instructorRepository.findById(id);
        System.out.println(instructor);
    }

    public void findAllByFirstName(String firstName){
        System.out.println(instructorRepository.findAllByFirstName(firstName));
    }

    public void findAllByLastName(String lastName){
        System.out.println(instructorRepository.findAllByLastName(lastName));
    }

    public void updateInstructorFirstName(String firstName,int id ){
       instructorRepository.updateInstructorFirstName(firstName,id);
    }

    public void updateInstructorLastName(String lastName,int id ){
        instructorRepository.updateInstructorLastName(lastName,id);
    }

    public void deleteInstructor(Instructor instructor){
        instructorRepository.delete(instructor);
    }

}
