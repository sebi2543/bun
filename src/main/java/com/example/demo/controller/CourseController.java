package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    final CourseService courseService;
    final CourseMapper courseMapper;
    final InstructorService instructorService;

    @GetMapping(value = {"/all"})
    public List<BasicCourseDTO>showMainPage(){
        List<Course>courses = courseService.getAll();
        return courseMapper.toBasics(courses);
    }

    @PostMapping("/search")
    public List<BasicCourseDTO>showSuitableCourses(@RequestBody BasicCourseDTO course) throws InvalidTitle {
        courseService.checkTitle(course);
        List<Course>courses = courseService.getByTitle(course);
        return (courseMapper.toBasics(courses));
    }

    @PostMapping("/suggestion")
    public List<BasicCourseDTO>showAutoSuggestion(@RequestBody BasicCourseDTO course){
        List<Course>courses = courseService.getByTitleLike(course);
        return (courseMapper.toBasics(courses));
    }

    @GetMapping("/{id}")
    public BasicCourseDTO showIdCourse(@PathVariable int id){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course = courseService.getById(new IdentificationCourseDTO((long) id));
        return (courseMapper.toBasic(course));
    }

    @PostMapping("/add")
    public void addCourse(@RequestBody BasicCourseDTO basicCourseDTO) throws InvalidTitle {
        courseService.add(basicCourseDTO);
    }

    @PostMapping("/{id}/assign-instructor")
    public void  assignCourse(@PathVariable int id, @RequestBody IdentificationInstructorDTO identificationInstructorDTO){
     courseService.assignInstructor(new IdentificationCourseDTO((long) id),identificationInstructorDTO);
    }

    @PutMapping("/{id}/update")
    public void updateCourse(@PathVariable int id,@RequestBody BasicCourseDTO basicCourseDTO){
       courseService.update(new IdentificationCourseDTO((long) id),basicCourseDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCourse(@PathVariable int id){
        courseService.delete(new IdentificationCourseDTO((long) id));
    }

    @GetMapping("/best")
    public List<SortCourseDTO>bestCourse(){
        return (courseMapper.toSort(courseService.getAllOrderByRatingDesc()));
    }
}
