package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.repository.InstructorProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorProfileService {
    @Autowired
    InstructorProfileRepository instructorProfileRepository;

    public void insertInstructorProfile(InstructorProfile instructorProfile){
        instructorProfileRepository.save(instructorProfile);
    }
    public void showInstructorsProfiles(){
        List<InstructorProfile> profiles =instructorProfileRepository.findAll();
        for (InstructorProfile profile : profiles)
            System.out.println(profile);
    }


}
