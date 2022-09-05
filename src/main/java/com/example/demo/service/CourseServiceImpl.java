package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {

    final CourseRepository courseRepository;
    final InstructorRepository instructorRepository;
    final CourseMapper courseMapper;

    private List<Course> findAll() {
        return (courseRepository.findAll());
    }

    private Optional<Course> findById(long courseId) {
        return (courseRepository.findById(courseId));
    }

    private List<Course> findByTitleLike(BasicCourseDTO basicCourseDTO) {
        return courseRepository.findByTitleLike(basicCourseDTO.getTitle());
    }

    private List<Course> findByTitle(BasicCourseDTO basicCourseDTO) {
        return courseRepository.findByTitle(basicCourseDTO.getTitle());
    }

    public List<Course> getAll() {
        return this.findAll();
    }

    public Course getById(long courseId) {
        return this.findById(courseId).get();
    }

    public List<Course> getByTitleLike(BasicCourseDTO basicCourseDTO) {
        return this.findByTitleLike(basicCourseDTO);
    }

    public List<Course> getByTitle(BasicCourseDTO basicCourseDTO) {
        return this.findByTitle(basicCourseDTO);
    }

    @Override
    public void save(Course course) {
        courseRepository.save(course);
    }
    @Override
    public void delete(long courseId) {
        courseRepository.delete(this.getById(courseId));
    }

    @Override
    public void update(long courseId, BasicCourseDTO basicCourseDTO) {
        Course course=this.getById(courseId);
        course.setTitle(basicCourseDTO.getTitle());
        this.courseRepository.save(course);
    }

    @Override
    public void add(BasicCourseDTO basicCourseDTO) {
        Course course=courseMapper.toEntity(basicCourseDTO);
        log.error("there was{},and now are{}",courseRepository.findAll().size(),courseRepository.findAll().size()+1);
        this.courseRepository.save(course);
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
        this.courseRepository.save(course);
    }

    @Override
    public List<Course> getAllOrderByRatingDesc() {
        return courseRepository.findAllOrderByRating();
    }

    @Override
    public void assignInstructor(long courseId,long  instructorId) {
        Course course = courseRepository.findById(courseId).get();
        Instructor instructor = instructorRepository.findById(instructorId).get();
        course.setInstructor(instructor);
        this.save(course);
    }

}

