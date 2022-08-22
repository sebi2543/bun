package com.example.demo.controller;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.mapper.InstructorProfileMapper;
import com.example.demo.service.InstructorProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "instructor/profile")
@RestController
@RequiredArgsConstructor
public class InstructorProfileController {

    final InstructorProfileService instructorProfileService;
    final InstructorProfileMapper instructorProfileMapper;

    @GetMapping("/all")
    public HttpEntity<List<BasicInstructorProfileDTO>>all(){
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));

    }

    @GetMapping("/{id}")
    public HttpEntity<BasicInstructorProfileDTO>all(@PathVariable int id){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        return new HttpEntity<>(instructorProfileMapper.instructorProfileToDTO(instructorProfileService.getById(identificationProfileDTO)));

    }
    @PostMapping("/add")
    public HttpEntity<List<BasicInstructorProfileDTO>>add(@RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.checkInstructorProfile(basicInstructorProfileDTO);
        instructorProfileService.save(instructorProfileMapper.instructorDTOToInstructor(basicInstructorProfileDTO));
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }

    @GetMapping("/{id}/delete")
    public HttpEntity<List<BasicInstructorProfileDTO>>delete(@PathVariable int  id){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(identificationProfileDTO);
        instructorProfileService.delete(instructorProfile);
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }

    @GetMapping("/{id}/update")
    public HttpEntity<List<BasicInstructorProfileDTO>>delete(@PathVariable int  id, @RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(identificationProfileDTO);
        instructorProfile.setLinkedin(basicInstructorProfileDTO.getLinkedin());
        instructorProfile.setYoutube(basicInstructorProfileDTO.getYoutube());
        instructorProfileService.save(instructorProfile);
        return new HttpEntity<>(instructorProfileMapper.instructorsProfileToDTOS(instructorProfileService.getAll()));
    }



}
