package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidTitle;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

  void save(Course course);
  void delete(Course course);
  List<Course> showAll();
  Optional<Instructor>findById(int id);
  List<Course>findByTitle(String title);
  List<Course>findSuggestion(String title);
  void checkTitle(String title) throws InvalidTitle;
}
