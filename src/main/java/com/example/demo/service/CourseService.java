package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

    Optional<List<Course>>findAll();
    Optional<Course>findById(IdentificationCourseDTO course);
    Optional<List<Course>>findByTitle(BasicCourseDTO basicCourseDTO);
    Optional<List<Course>>findByTitleLike(BasicCourseDTO basicCourseDTO);
    List<Course>getAll();
    Course getById(IdentificationCourseDTO course);
    List<Course>getByTitleLike(BasicCourseDTO basicCourseDTO);
    List<Course>getByTitle(BasicCourseDTO basicCourseDTO);
    List<Course>getAllOrderByRatingDesc();
    Course save(Course course);
    void delete(Course course);
    void checkTitle(BasicCourseDTO basicCourseDTO);
    void checkId(IdentificationCourseDTO identificationCourseDTO);
    void update(IdentificationCourseDTO identificationCourseDTO,BasicCourseDTO basicCourseDTO);
    void assignInstructor(IdentificationCourseDTO identificationCourseDTO, IdentificationInstructorDTO identificationInstructorDTO);

}
