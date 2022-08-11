package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.service.InstructorRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "instructor")
public class InstructorController {

    @Autowired
    InstructorRepositoryService instructorRepositoryService;

    @GetMapping(value ={"/all"})
    public List<Instructor> showMainPage(){
        return instructorRepositoryService.showAll();

    }

    @GetMapping("/add")
    public Course add(){
        return new Course();
    }

    @PostMapping("/search")
    public List<Instructor> showSuitableInstructors(@RequestParam String firstname,@RequestParam String lastname){
        System.err.println(firstname+lastname);
        return instructorRepositoryService.findByFullName(firstname,lastname);
    }


}
