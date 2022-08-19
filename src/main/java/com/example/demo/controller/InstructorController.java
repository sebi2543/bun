package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidFirstName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorMapper instructorMapper;

    @Autowired
    CourseService courseService;

    @GetMapping(value = {"/all"})
    public HttpEntity<List<InstructorDTO>> showMainPage() {
        List<Instructor> instructors = instructorService.getAll();
        return new HttpEntity<>(instructorMapper.instructorsToDTOS(instructors));
    }

    @PostMapping("/add")
    public HttpEntity<InstructorDTO> add(@RequestBody InstructorDTO instructorDTO) throws InvalidFirstName {
        instructorService.checkInstructor(instructorDTO);
        instructorService.save(instructorMapper.instructorDTOtoInstructor(instructorDTO));
        return new HttpEntity<>(instructorDTO);
    }

    @PostMapping("/search")
    public HttpEntity<List<InstructorDTO>> showSuitableInstructors(@RequestBody InstructorDTO instructor) {
        List<Instructor> instructors = instructorService.getByFullName(instructor);
        return new HttpEntity<>(instructorMapper.instructorsToDTOS(instructors));
    }

    @GetMapping("/{id}")
    public HttpEntity<InstructorDTO> showIdInstructor(@PathVariable int id) {
        instructorService.checkId(new InstructorDTOId((long) id));
        Instructor instructor = instructorService.getById(new InstructorDTOId((long) id));
        return new HttpEntity<InstructorDTO>(instructorMapper.instructorToDTO(instructor));
    }

    @GetMapping("/{id}/delete")
    public HttpEntity<List<InstructorDTO>> deleteIdInstructor(@PathVariable int id) {
        instructorService.checkId(new InstructorDTOId((long) id));
        instructorService.delete(instructorMapper.instructorDTOIdTOInstructor(new InstructorDTOId((long) id)));
        return new HttpEntity<>(instructorMapper.instructorsToDTOS(instructorService.getAll()));
    }

    //NEFUNCTIONAL
    @PostMapping("/{id}/assign-course")
     public void add(@PathVariable int id, @RequestBody CourseDTOId courseDTOId){
        InstructorDTOId instructorDTOId=new InstructorDTOId((long) id);
        Instructor instructor=instructorService.getById(instructorDTOId);
        Course course=courseService.getById(courseDTOId);
        instructor.addCourse(course);
        instructorService.save(instructor);
        System.err.println(course);
        System.err.println(instructor);
        System.err.println(instructorService.getById(instructorDTOId));
    }

    @PostMapping("/{id}/update")
    public HttpEntity<List<Instructor>>update(@PathVariable int id,@RequestBody InstructorDTO instructorDTO){
        instructorService.checkId(new InstructorDTOId((long) id));
        Instructor instructor=instructorService.getById(new InstructorDTOId((long) id));
        instructor.setFirstName(instructorDTO.getFirstName());
        instructor.setLastName(instructorDTO.getLastName());
        instructorService.save(instructor);
        return new HttpEntity<>(instructorService.getAll());
    }

    @GetMapping("/best")
    public HttpEntity<List<InstructorDTORating>> best(){
        return new HttpEntity<>(instructorMapper.instructorsToInstructorDTOSRating(instructorService.getAllOrderByRating()));
    }
}


