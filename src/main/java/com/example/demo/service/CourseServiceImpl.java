package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    final CourseRepository courseRepository;
    final InstructorRepository instructorRepository;
    final CourseMapper courseMapper;

    public Optional<List<Course>> findAll() {
        return Optional.of(courseRepository.findAll());
    }

    public Optional<Course> findById(long courseId) {
        return (courseRepository.findById(courseId));
    }

    public Optional<List<Course>> findByTitleLike(BasicCourseDTO basicCourseDTO) {
        return courseRepository.findByTitleLike(basicCourseDTO.getTitle());
    }

    public Optional<List<Course>> findByTitle(BasicCourseDTO basicCourseDTO) {
        return courseRepository.findByTitle(basicCourseDTO.getTitle());
    }

    public List<Course> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Course getById(long courseId) {
        return this.findById(courseId).orElseThrow(InvalidParameterException::new);
    }

    public List<Course> getByTitleLike(BasicCourseDTO basicCourseDTO) {
        return this.findByTitleLike(basicCourseDTO).orElseThrow(InvalidParameterException::new);
    }

    public List<Course> getByTitle(BasicCourseDTO basicCourseDTO) {
        return this.findByTitle(basicCourseDTO).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
    @Override
    public void delete(long courseId) {
        Course course=this.getById(courseId);
        courseRepository.delete(course);
    }

    @Override
    public void update(long courseId, BasicCourseDTO basicCourseDTO) {
        Course course=this.getById(courseId);
        course.setTitle(basicCourseDTO.getTitle());
        this.save(course);
    }


    @Override
    public void assignInstructor(long courseId,long  instructorId) {
        Course course = courseRepository.findById(courseId).get();
        Instructor instructor = instructorRepository.findById(instructorId).get();
        course.setInstructor(instructor);
        this.save(course);
    }

    @Override
    public void add(BasicCourseDTO basicCourseDTO) {
        Course course=courseMapper.toEntity(basicCourseDTO);
        this.save(course);
    }

    @Override
    public List<BasicCourseDTO> showMainPage() {
        List<Course>courses = this.getAll();
        return courseMapper.toBasics(courses);
    }

    @Override
    public List<BasicCourseDTO> showSuitableCourses(BasicCourseDTO course) {
        List<Course>courses = this.getByTitle(course);
        return (courseMapper.toBasics(courses));
    }

    @Override
    public List<BasicCourseDTO> showAutoSuggestion(BasicCourseDTO course) {
        List<Course>courses = this.getByTitleLike(course);
        return (courseMapper.toBasics(courses));
    }

    @Override
    public BasicCourseDTO showIdCourse(long id) {
        Course course = this.getById(id);
        return (courseMapper.toBasic(course));
    }

    @Override
    public float calculateAverage(long id) {
        Course course=this.getById(id);
        return course.getRating();
    }

    @Override
    public void giveGrade(long  id,long grade) {
        Course course=this.getById(id);
        course.addGrade(grade);
        this.save(course);
    }


    @Override
    public List<Course> getAllOrderByRatingDesc() {
        return courseRepository.findAllOrderByRating();
    }


}

