package com.example.demo.service;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CourseRepositoryService {

  void  save(Course course);
  void  delete(Course course);
  void populateDataBase();
  List<Course> showAll();
}
