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
        List<Instructor>instructors= instructorService.getAll();
        return new HttpEntity<>( instructorMapper.instructorsToDTOS(instructors));
    }

    @PostMapping("/add")
    public HttpEntity<InstructorDTO>add(@RequestBody InstructorDTO instructorDTO) throws InvalidName {
        instructorService.checkInstructor(instructorDTO);
        instructorService.save(instructorMapper.instructorDTOtoInstructor(instructorDTO));
        return new HttpEntity<>(instructorDTO);
    }

    @PostMapping("/search")
    public HttpEntity<List<InstructorDTO>>showSuitableInstructors(@RequestBody InstructorDTO instructor) {
        List<Instructor> instructors= instructorService.getByFullName(instructor);
        return new HttpEntity<>(instructorMapper.instructorsToDTOS(instructors));
    }

}


