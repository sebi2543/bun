package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }


    public Optional<List<Instructor>> findAll() {
        return Optional.of(instructorRepository.findAll());
    }

    public Optional<Instructor> findById(long instructorId) {
        return instructorRepository.findById(instructorId);
    }

    public Optional<List<Instructor>> findByFullName(BasicInstructorDTO instructor) {
        return instructorRepository.findByFirstNameAndLastName(instructor.getFirstName(), instructor.getLastName());
    }

    public List<Instructor> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Instructor getById(long  instructorId) {
        return this.findById(instructorId).orElseThrow(InvalidParameterException::new);
    }

    public List<Instructor> getByFullName(BasicInstructorDTO instructor) {
        return this.findByFullName(instructor).orElseThrow(InvalidParameterException::new);
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
    public void assignCourse(long  instructorId, long  courseId) {
        Instructor instructor=this.findById(instructorId).get();
        Course course= courseRepository.findById(courseId).get();
        instructor.addCourse(course);
        this.save(instructor);
    }

    @Override
    public void update(long  instructorId, BasicInstructorDTO basicInstructorDTO) {
        Instructor instructor =this.getById(instructorId);
        instructor.setFirstName(basicInstructorDTO.getFirstName());
        instructor.setLastName(basicInstructorDTO.getLastName());
        this.save(instructor);
    }

    @Override
    public void add(BasicInstructorDTO basicInstructorDTO) {
      Instructor instructor=instructorMapper.toEntity(basicInstructorDTO);
      this.save(instructor);
    }

    @Override
    public List<Instructor> getAllOrderByRating() {
        return instructorRepository.findAllOrderByRating();
    }


}

