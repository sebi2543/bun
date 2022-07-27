package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public void insertCourse(Course course){
        courseRepository.save(course);
    }
    public void showCourses(){
       List<Course> courses = courseRepository.findAll();
       for (Course course:courses)
           System.out.println(course);
    }
    public void  findById(int id){
        Course course=courseRepository.findById(id);
        System.out.println(course);
    }
    public void findByTitle(String title){
        Course course=courseRepository.findByTitle(title);
        System.out.println(course);
    }
    public void findByAnyTitle(ArrayList<String> titles) {
        ArrayList<Course> courses = courseRepository.findByAnyTitle(titles);
        for (Course course:courses)
            System.out.println(course);
    }
    public void updateCourseTitle(String title,int id){
        courseRepository.updateTitle(title,id);
    }

    public void deleteCourse(Course course){
        courseRepository.delete(course);
    }


}
