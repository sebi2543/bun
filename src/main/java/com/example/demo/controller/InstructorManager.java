package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/instructor")
public class InstructorManager {
@Autowired
    InstructorService instructorService;


    @GetMapping(value = "/showinstructors")
    public void showInstructors(){
        System.err.println(instructorService.selectTheBestInstructors());
    }

    @PostMapping(value = "/search")
    public void findBy(@RequestParam String firstName,@RequestParam String lastName){
//        System.err.println(instructorService.findBy(firstName,lastName));
        System.err.println(firstName+lastName);
    }
    @RequestMapping
    public void defautMapping(){
        System.err.println("this is the default instructor page");

    }






}
