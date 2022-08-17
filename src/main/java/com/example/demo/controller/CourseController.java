package com.example.demo.controller;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "course")
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseMapper courseMapper;

    @GetMapping(value = {"/all"})
    public HttpEntity<List<CourseDTO>>showMainPage(){
        List<Course>courses = courseService.getAll();
        return  new HttpEntity<>(courseMapper.coursesToDTOS(courses));
    }

    @PostMapping("/search")
    public HttpEntity<List<CourseDTO>>showSuitableCourses(@RequestBody CourseDTO course) throws InvalidTitle {
        courseService.checkTitle(course.getTitle());
        List<Course>courses = courseService.getByTitle(course.getTitle());
        return new HttpEntity<>(courseMapper.coursesToDTOS(courses));
    }

    @PostMapping("/auto-suggestion")
    public HttpEntity<List<CourseDTO>>showAutoSuggestion(@RequestBody CourseDTO course){
        List<Course>courses = courseService.getByTitleLike(course.getTitle());
        return new HttpEntity<>(courseMapper.coursesToDTOS(courses));
    }
}

