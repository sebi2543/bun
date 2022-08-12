package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.service.CourseRepositoryService;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
    public HttpEntity<List<Course>> showMainPage(){
       return new HttpEntity<>(courseRepositoryService.showAll());
    }

    @PostMapping("/search")
    public HttpEntity<List<Course>> showSuitableCourses(@RequestBody String title) throws InvalidTitle {
            courseService.checkTitle(title);
            return new HttpEntity<>(courseRepositoryService.findByTitle(title));
    }

    @PostMapping("/auto-suggestion")
    public HttpEntity<List<Course>>showAutoSuggestion(@RequestBody String title){
            return new HttpEntity<>(courseRepositoryService.findSuggestion(title));
    }

}
