package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "instructor")
@RequiredArgsConstructor
public class InstructorController {

    final InstructorService instructorService;
    final InstructorMapper instructorMapper;
    final CourseService courseService;

    @GetMapping(value = {"/all"})
    public List<BasicInstructorDTO> showMainPage() {
       return instructorService.showAll();
    }

    @PostMapping("/add")
    public void  addInstructor(@Valid @RequestBody BasicInstructorDTO basicInstructorDTO) {
        instructorService.add(basicInstructorDTO);
    }

    @PostMapping("/search")
    public List<BasicInstructorDTO> showSuitableInstructors(BasicInstructorDTO instructor) {
       return instructorService.showSuitableInstructors(instructor);
    }

    @GetMapping("/{id}")
    public BasicInstructorDTO showIdInstructor(@PathVariable int id) {
        return instructorService.showIdInstructor(id);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteIdInstructor(@PathVariable int id) {
       instructorService.delete(id);
    }

    @PostMapping("/{id}/assign-course")
     public void assignCourse(@PathVariable int id, @RequestBody long courseId){
        instructorService.assignCourse( id,courseId);
    }
    @PostMapping("/{id}/assign-profile")
    public void assignProfile(@PathVariable int id,@RequestBody long profileId){
        instructorService.assignProfile(id,profileId);
    }
    @PutMapping("/{id}/update")
    public void updateInstructor(@PathVariable int id,@Valid @RequestBody BasicInstructorDTO basicInstructorDTO){
       instructorService.update(id,basicInstructorDTO);
    }

    @GetMapping("/best")
    public List<SortInstructorDTO> bestInstructor(){
        return (instructorMapper.toSort(instructorService.getAllOrderByRating()));
    }

    @GetMapping("/{id}/average")
    public float calculateAverage(@PathVariable long id){
        return instructorService.calculateAverage(id);
    }
    @GetMapping("{id}/get-courses")
    public List<Course>showCourses(@PathVariable long id){
        return  instructorService.getCourses(id);
    }
}


