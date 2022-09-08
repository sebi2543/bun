package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Instructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface InstructorService {

    List<Instructor> getAll();
    Instructor getById(long instructorId);
    List<Instructor> getByFullName(BasicInstructorDTO instructor);
    List<Instructor>getAllOrderByRating();
    void save(Instructor instructor);
    void delete(long instructorId);
    void assignProfile(long instructorId,long profileId);
    void update(long instructorId,BasicInstructorDTO basicInstructorDTO);
    void add(BasicInstructorDTO basicInstructorDTO);
    List<BasicInstructorDTO> showAll();
    List<BasicInstructorDTO> showSuitableInstructors(BasicInstructorDTO instructor);
    BasicInstructorDTO showIdInstructor(int id);
    float calculateAverage(long id);
    List<BasicCourseDTO> getCourses(long id);
}
