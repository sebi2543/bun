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
import java.util.List;

@RequestMapping(value = "course")
@RestController
@RequiredArgsConstructor
public class CourseController {

   final CourseService courseService;
   final CourseMapper courseMapper;
   final InstructorService instructorService;

    @GetMapping(value = {"/all"})
    public HttpEntity<List<BasicCourseDTO>>showMainPage(){
        List<Course>courses = courseService.getAll();
        return  new HttpEntity<>(courseMapper.toBasics(courses));
    }

    @PostMapping("/search")
    public HttpEntity<List<BasicCourseDTO>>showSuitableCourses(@RequestBody BasicCourseDTO course) throws InvalidTitle {
        courseService.checkTitle(course);
        List<Course>courses = courseService.getByTitle(course);
        return new HttpEntity<>(courseMapper.toBasics(courses));
    }

    @PostMapping("/suggestion")
    public HttpEntity<List<BasicCourseDTO>>showAutoSuggestion(@RequestBody BasicCourseDTO course){
        List<Course>courses = courseService.getByTitleLike(course);
        return new HttpEntity<>(courseMapper.toBasics(courses));
    }

    @GetMapping("/{id}")
    public HttpEntity<BasicCourseDTO>showIdCourse(@PathVariable int id){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course = courseService.getById(new IdentificationCourseDTO((long) id));
        return new HttpEntity<BasicCourseDTO>(courseMapper.toBasic(course));
    }

    @PostMapping("/add")
    public HttpEntity<List<BasicCourseDTO>>add(@RequestBody BasicCourseDTO basicCourseDTO) throws InvalidTitle {
        courseService.checkTitle(basicCourseDTO);
        courseService.save(courseMapper.toEntity(basicCourseDTO));
        return new HttpEntity<>(courseMapper.toBasics(courseService.getAll()));
    }

    //NEFUNCTIONAL
    @PostMapping("/{id}/assign-instructor")
    public HttpEntity<Course> assignCourse(@PathVariable int id, @RequestBody IdentificationInstructorDTO identificationInstructorDTO){
        IdentificationCourseDTO identificationCourseDTO = new IdentificationCourseDTO((long) id);
        Course course=courseService.getById(identificationCourseDTO);
        Instructor instructor=instructorService.getById(identificationInstructorDTO);
        course.setInstructor(instructor);
        courseService.save(course);
        return new HttpEntity<>(courseService.getById(identificationCourseDTO));
    }

    @PostMapping("/{id}/update")
    public HttpEntity<List<Course>>update(@PathVariable int id,@RequestBody BasicCourseDTO basicCourseDTO){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course=courseService.getById(new IdentificationCourseDTO((long) id));
        courseService.checkTitle(basicCourseDTO);
        course.setTitle(basicCourseDTO.getTitle());
        courseService.save(course);
        return new HttpEntity<>(courseService.getAll());
    }

    @GetMapping("/{id}/delete")
    public HttpEntity<List<BasicCourseDTO>>delete(@PathVariable int id){
        courseService.checkId(new IdentificationCourseDTO((long)id));
        Course course=courseService.getById(new IdentificationCourseDTO((long) id));
        courseService.delete(course);
        return new HttpEntity<>(courseMapper.toBasics(courseService.getAll()));
    }

    @GetMapping("/best")
    public HttpEntity<List<SortCourseDTO>>best(){
        return new HttpEntity<>(courseMapper.toSort(courseService.getAllOrderByRatingDesc()));
    }
}

