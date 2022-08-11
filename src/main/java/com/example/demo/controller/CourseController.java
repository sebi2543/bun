package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.exceptions.InvalidTitle;
import com.example.demo.service.CourseRepositoryService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "course")
@RestController
public class CourseController {

    @Autowired
    CourseRepositoryService courseRepositoryService;

    @Autowired
    CourseService courseService;

    @GetMapping(value = {"/all"})
    public List<Course>  showMainPage(){
       return courseRepositoryService.showAll();
    }

    @PostMapping("/search")
    public List<Course>showSuitableCourses(@RequestParam String title) throws InvalidTitle {
            courseService.checkTitle(title);
            return courseRepositoryService.findByTitle(title);
    }

    @PostMapping("/auto-suggestion")
    public List<Course>showAutoSuggestion(@RequestParam String title){
            return courseRepositoryService.findSuggestion(title);

    }

}
