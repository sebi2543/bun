package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidFirstName;
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
    public BasicInstructorDTO add(@Valid @RequestBody BasicInstructorDTO basicInstructorDTO) throws InvalidFirstName {
//        instructorService.checkInstructor(basicInstructorDTO);
        instructorService.save(instructorMapper.toEntity(basicInstructorDTO));
        return basicInstructorDTO;
    }

    @PostMapping("/search")
    public List<BasicInstructorDTO> showSuitableInstructors(@RequestBody BasicInstructorDTO instructor) {
        List<Instructor> instructors = instructorService.getByFullName(instructor);
        return (instructorMapper.toBasic(instructors));
    }

    @GetMapping("/{id}")
    public BasicInstructorDTO showIdInstructor(@PathVariable int id) {
        instructorService.checkId(new IdentificationInstructorDTO((long) id));
        Instructor instructor = instructorService.getById(new IdentificationInstructorDTO((long) id));
        return (instructorMapper.toBasic(instructor));
    }

    @DeleteMapping("/{id}/delete")
    public void deleteIdInstructor(@PathVariable int id) {
       instructorService.delete(new IdentificationInstructorDTO((long) id));
    }

    @PostMapping("/{id}/assign-course")
     public void assign(@PathVariable int id, @RequestBody IdentificationCourseDTO identificationCourseDTO){
        instructorService.assignCourse(new IdentificationInstructorDTO((long) id),identificationCourseDTO);
    }
    @PostMapping("/{id}/assign-profile")
    public void assignProfile(@PathVariable int id,@RequestBody IdentificationInstructorProfileDTO identificationInstructorProfileDTO){
        instructorService.assignProfile(new IdentificationInstructorDTO((long)id), identificationInstructorProfileDTO);
    }
    @PutMapping("/{id}/update")
    public void update(@PathVariable int id,@RequestBody BasicInstructorDTO basicInstructorDTO){
       instructorService.update(new IdentificationInstructorDTO((long) id),basicInstructorDTO);
    }

    @GetMapping("/best")
    public List<SortInstructorDTO> best(){
        return (instructorMapper.toSort(instructorService.getAllOrderByRating()));
    }
}


