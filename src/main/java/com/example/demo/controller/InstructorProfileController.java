package com.example.demo.controller;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.dto.InstructorDTOId;
import com.example.demo.dto.InstructorProfileDTO;
import com.example.demo.dto.InstructorProfileDTOId;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.mapper.InstructorProfileMapper;
import com.example.demo.service.InstructorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "instructor/profile")
@RestController
public class InstructorProfileController {

    @Autowired
    InstructorProfileService instructorProfileService;

    @Autowired
    InstructorProfileMapper instructorProfileMapper;

    @GetMapping("/all")
    public HttpEntity<List<InstructorProfileDTO>>all(){
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));

    }

    @GetMapping("/{id}")
    public HttpEntity<InstructorProfileDTO>all(@PathVariable int id){
        InstructorProfileDTOId instructorProfileDTOId=new InstructorProfileDTOId((long) id);
        return new HttpEntity<>(instructorProfileMapper.instructorProfileToDTO(instructorProfileService.getById(instructorProfileDTOId)));

    }
    @PostMapping("/add")
    public HttpEntity<List<InstructorProfileDTO>>add(@RequestBody InstructorProfileDTO instructorProfileDTO){
        instructorProfileService.save(instructorProfileMapper.instructorDTOToInstructor(instructorProfileDTO));
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }

    @GetMapping("/{id}/delete")
    public HttpEntity<List<InstructorProfileDTO>>delete(@PathVariable int  id){
        InstructorProfileDTOId instructorProfileDTOId=new InstructorProfileDTOId((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(instructorProfileDTOId);
        instructorProfileService.delete(instructorProfile);
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }

    @GetMapping("/{id}/update")
    public HttpEntity<List<InstructorProfileDTO>>delete(@PathVariable int  id, @RequestBody InstructorProfileDTO instructorProfileDTO ){
        InstructorProfileDTOId instructorProfileDTOId=new InstructorProfileDTOId((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(instructorProfileDTOId);
        instructorProfile.setLinkedin(instructorProfileDTO.getLinkedin());
        instructorProfile.setYoutube(instructorProfileDTO.getYoutube());
        instructorProfileService.save(instructorProfile);
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }



}
