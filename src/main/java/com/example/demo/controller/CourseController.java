package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RequestMapping(value = "course")
@RestController
@RequiredArgsConstructor
@Slf4j
public class CourseController {

    final CourseService courseService;
    final CourseMapper courseMapper;
    final InstructorService instructorService;
    Logger logger= LoggerFactory.getLogger(CourseController.class);

    @GetMapping(value = {"/all"})
    public List<BasicCourseDTO> showMainPage(){
//        logger.trace("A TRACE Message");
//        logger.debug("A DEBUG Message");
//        logger.info("An INFO Message");
//        logger.warn("A WARN Message");
//        logger.error("An ERROR Message");;
        return courseService.showMainPage();
    }
//    @RequestBody BasicCourseDTO course
    @GetMapping("/search")
    public List<BasicCourseDTO>showSuitableCourses()  {
        return courseService.showSuitableCourses(new BasicCourseDTO("java"));
//        return courseService.showMainPage();
    }

    @PostMapping("/suggestion")
    public List<BasicCourseDTO>showAutoSuggestion(){
        return courseService.showAutoSuggestion(new BasicCourseDTO("java"));
    }

    @GetMapping("/{id}")
    public BasicCourseDTO showIdCourse(@PathVariable int id){
        return courseService.showIdCourse(id);
    }

    @PostMapping("/add")
    public void addCourse(@Valid @RequestBody BasicCourseDTO basicCourseDTO){
        courseService.add(basicCourseDTO);
    }

    @PutMapping("/{id}/update")
    public void updateCourse(@PathVariable int id,@Valid @RequestBody BasicCourseDTO basicCourseDTO){
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

    @PostMapping("/{id}/give-grade")
    public void giveGrade(@PathVariable int id ,@RequestBody long grade){
        courseService.giveGrade(id,grade);
    }

    @GetMapping("/{id}/average")
    public Float calculateAverage(@PathVariable  long id){
         return  courseService.calculateAverage(id);
    }

    @PostMapping("/{id}/assign-instructor")
    public void  assignInstructor(@PathVariable int id, @RequestBody long  instructorId){
        courseService.assignInstructor(id,instructorId);
    }

}
