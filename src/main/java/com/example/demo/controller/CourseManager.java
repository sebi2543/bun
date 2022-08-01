package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseManager {
    @Autowired
    CourseService courseService;

    @GetMapping("/showcourses")
    public void findTheHighestRatingCourses(){

        System.err.println(courseService.findTheHighestRatingCourses(7));

    }

    @GetMapping("/search/{title}")
    public void findByTitle(@PathVariable  String title){
        System.err.println(courseService.findByTitle(title));
    }
    @RequestMapping
    public void defautMapping(){
        System.err.println("this is the default course page");
    }

}
