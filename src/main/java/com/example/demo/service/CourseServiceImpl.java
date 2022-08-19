package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.CourseDTOId;
import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseMapper courseMapper;

    public Course  save(Course course){
       return  courseRepository.save(course);
    }

    public void saveAll(List<Course> courses){
        courseRepository.saveAll(courses);
    }

    public void delete(Course course){
        courseRepository.delete(course);
    }

    public  void checkTitle(CourseDTO courseDTO){
        if (courseDTO.getTitle().length()==0)
            throw  new InvalidTitle();
    }

    public Optional<List<Course>>findAll(){
        return Optional.of(courseRepository.findAll());
    }

    public Optional<Course>findById(CourseDTOId course){
        return (courseRepository.findById(course.getId()));
    }

    public Optional<List<Course>>findByTitleLike(CourseDTO courseDTO){
        return courseRepository.findByTitleLike(courseDTO.getTitle());
    }

    public Optional<List<Course>>findByTitle(CourseDTO courseDTO){
        return courseRepository.findByTitle(courseDTO.getTitle());
    }

    public List<Course> getAll(){
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Course getById(CourseDTOId course){
        return this.findById(course).orElseThrow(InvalidParameterException::new);
    }

    public List<Course>getByTitleLike(CourseDTO courseDTO){
        return this.findByTitleLike(courseDTO).orElseThrow(InvalidParameterException::new);
    }

    public List<Course>getByTitle(CourseDTO courseDTO){
        return this.findByTitle(courseDTO).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public List<Course> getAllOrderByRatingDesc() {
       return courseRepository.findAllOrderByRating();
    }

}