package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void save(Course course){
        courseRepository.save(course);
    }

    public void show(){
        System.out.println(courseRepository.findAll());
    }

    public List<Course> findTheHighestRatingCourses(){
        return courseRepository.findByRatingGreaterThan(7);
    }




}
