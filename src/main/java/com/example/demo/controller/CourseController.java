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
        return (courseMapper.toBasics(courses));
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
    public List<BasicCourseDTO>add(@RequestBody BasicCourseDTO basicCourseDTO) throws InvalidTitle {
//        courseService.checkTitle(basicCourseDTO);
        courseService.save(courseMapper.toEntity(basicCourseDTO));
        return courseMapper.toBasics(courseService.getAll());
    }

    @PostMapping("/{id}/assign-instructor")
    public void  assignCourse(@PathVariable int id, @RequestBody IdentificationInstructorDTO identificationInstructorDTO){
     courseService.assignInstructor(new IdentificationCourseDTO((long) id),identificationInstructorDTO);
    }

    @PutMapping("/{id}/update")
    public List<Course>update(@PathVariable int id,@RequestBody BasicCourseDTO basicCourseDTO){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course=courseService.getById(new IdentificationCourseDTO((long) id));
        courseService.checkTitle(basicCourseDTO);
        course.setTitle(basicCourseDTO.getTitle());
        courseService.save(course);
        return (courseService.getAll());
    }

    @DeleteMapping("/{id}/delete")
    public List<BasicCourseDTO>delete(@PathVariable int id){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course=courseService.getById(new IdentificationCourseDTO((long) id));
        courseService.delete(course);
        return (courseMapper.toBasics(courseService.getAll()));
    }

    @GetMapping("/best")
    public List<SortCourseDTO>best(){
        return (courseMapper.toSort(courseService.getAllOrderByRatingDesc()));
    }
}
