package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.service.InstructorRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "instructors")
public class InstructorController {

    @Autowired
    InstructorRepositoryService instructorRepositoryService;

    @GetMapping(value ={"","/"})
    public List<Instructor> showMainPage(){
        return instructorRepositoryService.showAll();

    }

    @GetMapping("/add")
    public Course add(){
        Instructor inst1=new Instructor("JOHN","SMITH",new InstructorProfile("linkedin","youtub"));
        Instructor inst2=new Instructor("MICHAEL","OLSEN",new InstructorProfile("linkedin","youtub"));
        Instructor inst3=new Instructor("TEODOR","PATTERSON",new InstructorProfile("linkedin","youtub"));
        Instructor inst4=new Instructor("DAVID","GATE",new InstructorProfile("linkedin","youtub"));
        Instructor inst5=new Instructor("HARYY","BUFFET",new InstructorProfile("linkedin","youtub"));
        Course course=new Course("beginner-java");
        Course course1=new Course("master-java");
        Course course2=new Course("introduction-java");
        Course course3=new Course("introduction-python");
        Course course4=new Course("master-php");
        instructorRepositoryService.save(inst1);
        instructorRepositoryService.save(inst2);
        instructorRepositoryService.save(inst3);
        instructorRepositoryService.save(inst4);
        instructorRepositoryService.save(inst4);
        instructorRepositoryService.save(inst5);
        instructorRepositoryService.addCourse(course,inst1);
        instructorRepositoryService.addCourse(course1,inst2);
        instructorRepositoryService.addCourse(course2,inst3);
        instructorRepositoryService.addCourse(course3,inst4);
        instructorRepositoryService.addCourse(course4,inst5);
        return course;
    }

    @PostMapping("/search")
    public List<Instructor> showSuitableInstructors(@RequestParam String firstname,@RequestParam String lastname){
        System.err.println(firstname+lastname);
        return instructorRepositoryService.findByFullName(firstname,lastname);
    }


}
