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

  Optional<List<Course>>findAll();
  Optional<Course>findById(int id);
  Optional<List<Course>>findByTitle(String title);
  Optional<List<Course>>findByTitleLike(String title);
  List<Course>getAll();
  Course getById(int id);
  List<Course>getByTitleLike(String title);
  List<Course>getByTitle(String title);
  void checkTitle(String title) throws InvalidTitle;
  void save(Course course);
  void delete(Course course);
}
