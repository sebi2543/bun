package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.exceptions.InvalidName;
import com.example.demo.service.InstructorRepositoryService;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorRepositoryService instructorRepositoryService;


    @GetMapping(value = {"/all"})
    public List<Instructor> showMainPage() {
        return instructorRepositoryService.showAll();

    }

    @PostMapping("/add")
    public Instructor add(@RequestParam String firstName, @RequestParam String lastName) throws InvalidName {
        Instructor instructor = new Instructor(firstName, lastName);
        instructorService.checkInstructor(instructor);
        instructorRepositoryService.save(instructor);
        return instructor;
    }

    @PostMapping("/search")
    public List<Instructor> showSuitableInstructors(@RequestParam String firstname, @RequestParam String lastname) {
        System.err.println(firstname + lastname);
        return instructorRepositoryService.findByFullName(firstname, lastname);
    }
}


