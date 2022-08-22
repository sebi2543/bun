package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidFirstName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
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
    public BasicInstructorDTO add(@RequestBody BasicInstructorDTO basicInstructorDTO) throws InvalidFirstName {
        instructorService.checkInstructor(basicInstructorDTO);
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

    @GetMapping("/{id}/delete")
    public List<BasicInstructorDTO> deleteIdInstructor(@PathVariable int id) {
        instructorService.checkId(new IdentificationInstructorDTO((long) id));
        instructorService.delete(instructorMapper.toBasic(new IdentificationInstructorDTO((long) id)));
        return (instructorMapper.toBasic(instructorService.getAll()));
    }

    //NEFUNCTIONAL
    @PostMapping("/{id}/assign-course")
     public void add(@PathVariable int id, @RequestBody IdentificationCourseDTO identificationCourseDTO){
        IdentificationInstructorDTO identificationInstructorDTO =new IdentificationInstructorDTO((long) id);
        Instructor instructor=instructorService.getById(identificationInstructorDTO);
        Course course=courseService.getById(identificationCourseDTO);
        instructor.addCourse(course);
        instructorService.save(instructor);
        System.err.println(course);
        System.err.println(instructor);
        System.err.println(instructorService.getById(identificationInstructorDTO));
    }

    @PostMapping("/{id}/update")
    public List<Instructor>update(@PathVariable int id,@RequestBody BasicInstructorDTO basicInstructorDTO){
        instructorService.checkId(new IdentificationInstructorDTO((long) id));
        Instructor instructor=instructorService.getById(new IdentificationInstructorDTO((long) id));
        instructor.setFirstName(basicInstructorDTO.getFirstName());
        instructor.setLastName(basicInstructorDTO.getLastName());
        instructorService.save(instructor);
        return instructorService.getAll();
    }

    @GetMapping("/best")
    public List<SortInstructorDTO> best(){
        return (instructorMapper.toSort(instructorService.getAllOrderByRating()));
    }
}


