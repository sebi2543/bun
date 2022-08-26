package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

    Optional<List<Course>>findAll();
    Optional<Course>findById(long courseId);
    Optional<List<Course>>findByTitle(BasicCourseDTO basicCourseDTO);
    Optional<List<Course>>findByTitleLike(BasicCourseDTO basicCourseDTO);
    List<Course>getAll();
    Course getById(long courseId);
    List<Course>getByTitleLike(BasicCourseDTO basicCourseDTO);
    List<Course>getByTitle(BasicCourseDTO basicCourseDTO);
    List<Course>getAllOrderByRatingDesc();
    void save(Course course);
    void delete(long courseId);
    void update(long courseId,BasicCourseDTO basicCourseDTO);
    void assignInstructor(long courseId, long instructorId);
    void add(BasicCourseDTO basicCourseDTO);
    List<BasicCourseDTO>showMainPage();
    List<BasicCourseDTO>showSuitableCourses(BasicCourseDTO course);
    List<BasicCourseDTO>showAutoSuggestion(BasicCourseDTO course);
    public BasicCourseDTO showIdCourse(int id);

    }
