package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Course> findTheHighestRatingCourses(int rating){
        return courseRepository.findByRatingGreaterThan(rating);
    }

    public String  findByTitle(String title){
       Course course =courseRepository.findByTitle(title);
        if (course != null)
            return course.toString();
        else
        return "dosn't exist such a course";
    }




}
