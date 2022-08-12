package com.example.demo.controller;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidName;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.InstructorRepositoryService;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "instructor")
public class InstructorController {

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorRepositoryService instructorRepositoryService;

    @Autowired
    InstructorMapper instructorMapper;

    @GetMapping(value = {"/all"})
    public List<Instructor> showMainPage() {
        return instructorRepositoryService.showAll();

    }

    @PostMapping("/add")
    public HttpEntity<InstructorDTO> add(@RequestBody Instructor instructor) throws InvalidName {
        instructorService.checkInstructor(instructor);
        instructorRepositoryService.save(instructor);
        InstructorDTO instructorDTO= instructorMapper.InstructorToDTO(instructor);
        return new HttpEntity<InstructorDTO>(instructorDTO);
    }

    @PostMapping("/search")
    public List<Instructor> showSuitableInstructors(@RequestBody Instructor instructor) {
        return instructorRepositoryService.findByFullName(instructor);
    }
}


