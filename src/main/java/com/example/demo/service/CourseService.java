package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.CourseDTOId;
import com.example.demo.entity.Course;
import com.example.demo.exception.InvalidTitle;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface CourseService {

  Optional<List<Course>>findAll();
  Optional<Course>findById(CourseDTOId course);
  Optional<List<Course>>findByTitle(CourseDTO courseDTO);
  Optional<List<Course>>findByTitleLike(CourseDTO courseDTO);
  List<Course>getAll();
  Course getById(CourseDTOId course);
  List<Course>getByTitleLike(CourseDTO courseDTO);
  List<Course>getByTitle(CourseDTO courseDTO);
  List<Course>getAllOrderByRatingDesc();
  Course save(Course course);
  void delete(Course course);
  void checkTitle(CourseDTO courseDTO) throws InvalidTitle;
}
