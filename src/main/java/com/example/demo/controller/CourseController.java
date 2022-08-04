package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/search")
    public List<Course>showSuitableCourses(@RequestParam String title){
       return courseRepositoryService.findByTitle(title);
    }

}
