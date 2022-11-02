package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.FrontendCourseDTO;
import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CourseService {

    List<Course>getAll();
    Course getById(long courseId);
    List<Course>getByTitleLike(BasicCourseDTO basicCourseDTO);
    List<Course>getByTitle(BasicCourseDTO basicCourseDTO);
    List<Course>getAllOrderByRatingDesc();
    void save(Course course);
    void delete(long courseId);
    void update(long courseId,BasicCourseDTO basicCourseDTO);
    void add(BasicCourseDTO basicCourseDTO);
    List<FrontendCourseDTO>showMainPage();
    List<BasicCourseDTO>showSuitableCourses(BasicCourseDTO course);
    List<BasicCourseDTO>showAutoSuggestion(BasicCourseDTO course);
    BasicCourseDTO showIdCourse(long  id);
    float calculateAverage(long  id);
    void giveGrade(long id,long grade);
    void assignInstructor(long courseId,long  instructorId);
}
