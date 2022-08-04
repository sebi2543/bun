package com.example.demo.controller;

import com.example.demo.entity.Instructor;
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

}
