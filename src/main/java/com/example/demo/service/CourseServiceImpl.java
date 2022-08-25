package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidIdCourse;
import com.example.demo.exception.InvalidTitle;
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
    final InstructorService instructorService;
    final CourseMapper courseMapper;

    public void checkTitle(BasicCourseDTO basicCourseDTO) {
        if (basicCourseDTO.getTitle().length() == 0)
            throw new InvalidTitle();
    }

    public Optional<List<Course>> findAll() {
        return Optional.of(courseRepository.findAll());
    }

    public Optional<Course> findById(IdentificationCourseDTO course) {
        return (courseRepository.findById(course.getId()));
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

    public Course getById(IdentificationCourseDTO course) {
        return this.findById(course).orElseThrow(InvalidParameterException::new);
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
    public void delete(IdentificationCourseDTO identificationCourseDTO) {
        this.checkId(identificationCourseDTO);
        Course course=this.getById(identificationCourseDTO);
        courseRepository.delete(course);
    }

    @Override
    public void update(IdentificationCourseDTO identificationCourseDTO, BasicCourseDTO basicCourseDTO) {
        Course course=this.getById(identificationCourseDTO);
        course.setTitle(basicCourseDTO.getTitle());
        this.save(course);
    }


    @Override
    public void assignInstructor(IdentificationCourseDTO identificationCourseDTO, IdentificationInstructorDTO identificationInstructorDTO) {
        Course course = courseRepository.findById(identificationCourseDTO.getId()).get();
        Instructor instructor = instructorService.findById(identificationInstructorDTO).get();
        course.setInstructor(instructor);
        this.save(course);
    }

    @Override
    public void add(BasicCourseDTO basicCourseDTO) {
        Course course=courseMapper.toEntity(basicCourseDTO);
        this.save(course);
    }

    @Override
    public List<Course> getAllOrderByRatingDesc() {
        return courseRepository.findAllOrderByRating();
    }

    @Override
    public void checkId(IdentificationCourseDTO identificationCourseDTO) {
        Optional<Course> course = this.findById(identificationCourseDTO);
        if (course.isEmpty())
            throw new InvalidIdCourse();
    }

}

