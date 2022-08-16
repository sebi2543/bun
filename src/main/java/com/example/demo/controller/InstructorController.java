package com.example.demo.controller;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "instructor")
public class InstructorController{

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorMapper instructorMapper;

    @GetMapping(value = {"/all"})
    public HttpEntity<List<InstructorDTO>>showMainPage() {
        List<Instructor>instructors= instructorService.showAll();
        return new HttpEntity<>( instructorMapper.instructorsToDTOS(instructors));
    }

    @PostMapping("/add")
    public HttpEntity<InstructorDTO>add(@RequestBody Instructor instructor) throws InvalidName {
        instructorService.checkInstructor(instructor);
        instructorService.save(instructor);
        InstructorDTO instructorDTO= instructorMapper.instructorToDTO(instructor);
        return new HttpEntity<>(instructorDTO);
    }

    @PostMapping("/search")
    public HttpEntity<List<InstructorDTO>>showSuitableInstructors(@RequestBody Instructor instructor) {
        List<Instructor> instructors= instructorService.findByFullName(instructor);
        return new HttpEntity<>(instructorMapper.instructorsToDTOS(instructors));
    }

}


