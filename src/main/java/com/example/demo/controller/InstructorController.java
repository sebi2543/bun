package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Instructor;
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
        List<Instructor> instructors = instructorService.getAll();
        return (instructorMapper.toBasic(instructors));
    }

    @PostMapping("/add")
    public void  addInstructor(@Valid @RequestBody BasicInstructorDTO basicInstructorDTO) {
        instructorService.add(basicInstructorDTO);
    }

    @PostMapping("/search")
    public List<BasicInstructorDTO> showSuitableInstructors(@RequestBody BasicInstructorDTO instructor) {
        List<Instructor> instructors = instructorService.getByFullName(instructor);
        return (instructorMapper.toBasic(instructors));
    }

    @GetMapping("/{id}")
    public BasicInstructorDTO showIdInstructor(@PathVariable int id) {
        Instructor instructor = instructorService.getById(id);
        return (instructorMapper.toBasic(instructor));
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
    public void updateInstructor(@PathVariable int id,@RequestBody BasicInstructorDTO basicInstructorDTO){
       instructorService.update(id,basicInstructorDTO);
    }

    @GetMapping("/best")
    public List<SortInstructorDTO> bestInstructor(){
        return (instructorMapper.toSort(instructorService.getAllOrderByRating()));
    }
}


