package com.example.demo.controller;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.mapper.ProfileMapper;
import com.example.demo.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RequestMapping(value = "profile")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ProfileController {

    final ProfileService profileService;
    final ProfileMapper instructorProfileMapper;

    @GetMapping(value = "/all")
    public List<BasicProfileDTO>allProfile(){
        return (instructorProfileMapper.toBasic(profileService.getAll()));

    }
    @GetMapping("/{id}")
    public BasicProfileDTO idProfile(@PathVariable int id){
        return (instructorProfileMapper.toBasic(profileService.getById(id)));

    }
    @PostMapping("/add")
    public void addProfile(@Valid @RequestBody BasicProfileDTO basicProfileDTO){
        profileService.add(basicProfileDTO);
    }

    @DeleteMapping("/{id}/delete")
    public void deleteProfile(@PathVariable int  id){
        profileService.delete(id);
    }

    @PutMapping("/{id}/update")
    public void updateProfile(@PathVariable int  id, @Valid @RequestBody BasicProfileDTO basicProfileDTO){
        profileService.update(id, basicProfileDTO);
    }
}
