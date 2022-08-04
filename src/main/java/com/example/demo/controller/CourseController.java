package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RequestMapping(value = "courses")
@RestController
public class CourseController {

    @Autowired
    CourseRepositoryService courseRepositoryService;

    @GetMapping(value = {"/","",})
    public List<Course>  showMainPage(){
       return courseRepositoryService.showAll();
    }

}
