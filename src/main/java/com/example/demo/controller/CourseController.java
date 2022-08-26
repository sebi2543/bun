package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;

import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
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
    public List<BasicCourseDTO>showSuitableCourses(@Valid @RequestBody BasicCourseDTO course)  {
        List<Course>courses = courseService.getByTitle(course);
        return (courseMapper.toBasics(courses));
    }

    @PostMapping("/suggestion")
    public List<BasicCourseDTO>showAutoSuggestion(@Valid @RequestBody BasicCourseDTO course){
        List<Course>courses = courseService.getByTitleLike(course);
        return (courseMapper.toBasics(courses));
    }

    @GetMapping("/{id}")
    public BasicCourseDTO showIdCourse(@PathVariable int id){
        Course course = courseService.getById(id);
        return (courseMapper.toBasic(course));
    }

    @PostMapping("/add")
    public void addCourse(@Valid @RequestBody BasicCourseDTO basicCourseDTO){
        courseService.add(basicCourseDTO);
    }

    @PostMapping("/{id}/assign-instructor")
    public void  assignInstructor(@PathVariable int id, @RequestBody long  instructorId){
     courseService.assignInstructor(id,instructorId);
    }

    @PutMapping("/{id}/update")
    public void updateCourse(@PathVariable int id,@RequestBody BasicCourseDTO basicCourseDTO){
       courseService.update(id,basicCourseDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteCourse(@PathVariable int id){
        courseService.delete(id);
    }

    @GetMapping("/best")
    public List<SortCourseDTO>bestCourse(){
        return (courseMapper.toSort(courseService.getAllOrderByRatingDesc()));
    }
}
