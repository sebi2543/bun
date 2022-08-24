package com.example.demo.controller;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.dto.IdentificationInstructorProfileDTO;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.mapper.InstructorProfileMapper;
import com.example.demo.service.InstructorProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "instructor/profile")
@RestController
@RequiredArgsConstructor
public class InstructorProfileController {

    final InstructorProfileService instructorProfileService;
    final InstructorProfileMapper instructorProfileMapper;

    @GetMapping("/all")
    public List<BasicInstructorProfileDTO>allProfile(){
        return (instructorProfileMapper.toBasic(instructorProfileService.getAll()));

    }

    @GetMapping("/{id}")
    public BasicInstructorProfileDTO idProfile(@PathVariable int id){
        instructorProfileService.checkId(new IdentificationInstructorProfileDTO((long) id));
        IdentificationInstructorProfileDTO identificationInstructorProfileDTO =new IdentificationInstructorProfileDTO((long) id);
        return (instructorProfileMapper.toBasic(instructorProfileService.getById(identificationInstructorProfileDTO)));

    }
    @PostMapping("/add")
    public void addProfile(@RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.add(basicInstructorProfileDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteProfile(@PathVariable int  id){
        instructorProfileService.delete(new IdentificationInstructorProfileDTO((long) id));
    }

    @PutMapping("/{id}/update")
    public void updateProfile(@PathVariable int  id, @RequestBody BasicInstructorProfileDTO basicInstructorProfileDTO){
        instructorProfileService.update(new IdentificationInstructorProfileDTO((long) id),basicInstructorProfileDTO);
    }


}
