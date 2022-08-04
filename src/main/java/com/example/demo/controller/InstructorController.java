package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.service.InstructorRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Course add(Course course){
        Instructor inst1=new Instructor("JOHN","SMITH",new InstructorProfile("linkedin","youtub"));
        Course course1=(new Course("JAVA"));
        instructorRepositoryService.addCourse(course,inst1);
        return course1;
    }

}
