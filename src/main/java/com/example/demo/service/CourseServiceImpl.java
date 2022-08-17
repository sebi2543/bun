package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.ArrayList;
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
    public void save(Course course){
        courseRepository.save(course);
    }

    public void saveAll(List<Course> courses){
        courseRepository.saveAll(courses);
    }

    public void delete(Course course){
        courseRepository.delete(course);
    }

    public  void checkTitle(String title) throws InvalidTitle {
        if (title.length()==0)
            throw new InvalidTitle();
        if (title.length()>1 && title.length()<=3)
            throw  new InvalidTitle();
    }

    public Optional<List<Course>>findAll(){
        return Optional.of(courseRepository.findAll());
    }

    public Optional<Course>findById(int id){
        return (courseRepository.findById((long) id));
    }

    public Optional<List<Course>>findByTitleLike(String title){
        return courseRepository.findByTitleLike(title);
    }
    public Optional<List<Course>>findByTitle(String title){
        return courseRepository.findByTitle(title);
    }
    public List<Course> getAll(){
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Course getById(int id){
        return this.findById(id).orElseThrow(InvalidParameterException::new);
    }

    public List<Course>getByTitleLike(String title){
        return this.findByTitleLike(title).orElseThrow(InvalidParameterException::new);
    }

    public List<Course>getByTitle(String title){
        return this.findByTitle(title).orElseThrow(InvalidParameterException::new);
    }

}