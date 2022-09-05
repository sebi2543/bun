package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    final ProfileRepository profileRepository;
    final CourseRepository courseRepository;
    final InstructorMapper instructorMapper;
    final InstructorRepository instructorRepository;
    final CourseMapper courseMapper;

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    private List<Instructor> findAll() {
        return instructorRepository.findAll();
    }

    private Optional<Instructor> findById(long instructorId) {
        return instructorRepository.findById(instructorId);
    }

    private List<Instructor> findByFullName(BasicInstructorDTO instructor) {
        return instructorRepository.findByFirstNameAndLastName(instructor.getFirstName(), instructor.getLastName());
    }

    public List<Instructor> getAll() {
        return this.findAll();
    }

    public Instructor getById(long  instructorId) {
        return this.findById(instructorId).orElseThrow(InvalidParameterException::new);
    }

    public List<Instructor> getByFullName(BasicInstructorDTO instructor) {
        return this.findByFullName(instructor);
    }

    @Override
    public void delete(long  instructorId) {
        Instructor instructor=new Instructor();
        instructor.setId(instructorId);
        instructorRepository.delete(instructor);
    }

    @Override
    public void assignProfile(long  instructorId,long profileId) {
        Instructor instructor=this.findById(instructorId).get();
        Profile profile = profileRepository.findById(profileId).get();
        instructor.setProfile(profile);
        instructorRepository.save(instructor);
    }



    @Override
    public void update(long  instructorId, BasicInstructorDTO basicInstructorDTO) {
        Instructor instructor =this.getById(instructorId);
        instructor.setFirstName(basicInstructorDTO.getFirstName());
        instructor.setLastName(basicInstructorDTO.getLastName());
        this.instructorRepository.save(instructor);
    }

    @Override
    public void add(BasicInstructorDTO basicInstructorDTO) {
      Instructor instructor=instructorMapper.toEntity(basicInstructorDTO);
      this.instructorRepository.save(instructor);
    }

    @Override
    public List<BasicInstructorDTO> showAll() {
        List<Instructor> instructors = this.getAll();
        return (instructorMapper.toBasic(instructors));
    }

    @Override
    public List<BasicInstructorDTO> showSuitableInstructors(BasicInstructorDTO instructor) {
        List<Instructor> instructors = this.getByFullName(instructor);
        return (instructorMapper.toBasic(instructors));
    }

    @Override
    public BasicInstructorDTO showIdInstructor(int id) {
        Instructor instructor = this.getById(id);
        return (instructorMapper.toBasic(instructor));
    }

    @Override
    public float calculateAverage(long id) {
        Instructor instructor= this.getById(id);
        return instructor.calculateRating();
    }

    @Override
    @Transactional
    public List<BasicCourseDTO> getCourses(long id) {
        Instructor instructor=this.getById(id);
        return courseMapper.toBasics(courseRepository.findAll());
    }

    @Override
    public List<Instructor> getAllOrderByRating() {
        return instructorRepository.findAllOrderByRating();
    }
}

