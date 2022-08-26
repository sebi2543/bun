package com.example.demo.controller;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.mapper.ProfileMapper;
import com.example.demo.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "instructor/profile")
@RestController
@RequiredArgsConstructor
public class ProfileController {

    final ProfileService profileService;
    final ProfileMapper instructorProfileMapper;

    @GetMapping("/all")
    public List<BasicProfileDTO>allProfile(){
        return (instructorProfileMapper.toBasic(profileService.getAll()));

    }

    @GetMapping("/{id}")
    public BasicProfileDTO idProfile(@PathVariable int id){
        return (instructorProfileMapper.toBasic(profileService.getById(id)));

    }
    @PostMapping("/add")
    public void addProfile(@RequestBody BasicProfileDTO basicProfileDTO){
        profileService.add(basicProfileDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteProfile(@PathVariable int  id){
        profileService.delete(id);
    }

    @PutMapping("/{id}/update")
    public void updateProfile(@PathVariable int  id, @RequestBody BasicProfileDTO basicProfileDTO){
        profileService.update(id, basicProfileDTO);
    }


}
