package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    void checkTitle(String title) throws InvalidTitle;
    List<CourseDTO> CourseToDOS (List<Course> course);
}
