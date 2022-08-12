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
    public HttpEntity<List<InstructorDTO>> showMainPage() {
        List<Instructor>instructors=instructorRepositoryService.showAll();
        return new HttpEntity<>(instructorService.InstructorsToDTOS(instructors));
    }

    @PostMapping("/add")
    public HttpEntity<InstructorDTO> add(@RequestBody Instructor instructor) throws InvalidName {
        instructorService.checkInstructor(instructor);
        instructorRepositoryService.save(instructor);
        InstructorDTO instructorDTO= instructorMapper.InstructorToDTO(instructor);
        return new HttpEntity<>(instructorDTO);
    }

    @PostMapping("/search")
    public HttpEntity<List<InstructorDTO>> showSuitableInstructors(@RequestBody Instructor instructor) {
      List<Instructor> instructors=instructorRepositoryService.findByFullName(instructor);
      return new HttpEntity<>(instructorService.InstructorsToDTOS(instructors));
    }
}


