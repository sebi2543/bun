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
    public List<BasicInstructorProfileDTO>all(){
        return (instructorProfileMapper.toBasic(instructorProfileService.getAll()));

    }

    @GetMapping("/{id}")
    public BasicInstructorProfileDTO all(@PathVariable int id){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        return (instructorProfileMapper.toBasic(instructorProfileService.getById(identificationProfileDTO)));

    }
    @PostMapping("/add")
    public List<BasicInstructorProfileDTO>add(@RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.checkInstructorProfile(basicInstructorProfileDTO);
        instructorProfileService.save(instructorProfileMapper.toEntity(basicInstructorProfileDTO));
        return (instructorProfileMapper.toBasic(instructorProfileService.getAll()));
    }

    @DeleteMapping("/{id}/delete")
    public List<BasicInstructorProfileDTO>delete(@PathVariable int  id){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(identificationProfileDTO);
        instructorProfileService.delete(instructorProfile);
        return (instructorProfileMapper.toBasic(instructorProfileService.getAll()));
    }

    @PutMapping("/{id}/update")
    public List<BasicInstructorProfileDTO>delete(@PathVariable int  id, @RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.checkId(new IdentificationProfileDTO((long) id));
        IdentificationProfileDTO identificationProfileDTO =new IdentificationProfileDTO((long) id);
        InstructorProfile instructorProfile=instructorProfileService.getById(identificationProfileDTO);
        instructorProfile.setLinkedin(basicInstructorProfileDTO.getLinkedin());
        instructorProfile.setYoutube(basicInstructorProfileDTO.getYoutube());
        instructorProfileService.save(instructorProfile);
        return (instructorProfileMapper.toBasic(instructorProfileService.getAll()));
    }


}
