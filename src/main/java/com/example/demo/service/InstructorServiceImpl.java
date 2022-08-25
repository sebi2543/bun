package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.dto.IdentificationProfileDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.exception.InvalidIdInstructor;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    final ProfileService profileService;
    final CourseRepository courseRepository;
    final InstructorMapper instructorMapper;
    final InstructorRepository instructorRepository;

    public void save(Instructor instructor) {
        instructorRepository.save(instructor);
    }


    public Optional<List<Instructor>> findAll() {
        return Optional.of(instructorRepository.findAll());
    }

    public Optional<Instructor> findById(IdentificationInstructorDTO instructor) {
        return instructorRepository.findById(instructor.getId());
    }

    public Optional<List<Instructor>> findByFullName(BasicInstructorDTO instructor) {
        return instructorRepository.findByFirstNameAndLastName(instructor.getFirstName(), instructor.getLastName());
    }

    public List<Instructor> getAll() {
        return this.findAll().orElseThrow(InvalidParameterException::new);
    }

    public Instructor getById(IdentificationInstructorDTO instructor) {
        return this.findById(instructor).orElseThrow(InvalidParameterException::new);
    }

    public List<Instructor> getByFullName(BasicInstructorDTO instructor) {
        return this.findByFullName(instructor).orElseThrow(InvalidParameterException::new);
    }

    @Override
    public void delete(IdentificationInstructorDTO identificationInstructorDTO) {
        this.checkId(identificationInstructorDTO);
        instructorRepository.delete(instructorMapper.toEntity(identificationInstructorDTO));
    }

    @Override
    public void checkId(IdentificationInstructorDTO identificationInstructorDTO) {
        Optional<Instructor> instructor=this.findById(identificationInstructorDTO);
        if (instructor.isEmpty())
            throw new InvalidIdInstructor();
    }

    @Override
    public void assignProfile(IdentificationInstructorDTO identificationInstructorDTO, IdentificationProfileDTO identificationProfileDTO) {
        Instructor instructor=this.findById(identificationInstructorDTO).get();
        Profile profile = profileService.findById(identificationProfileDTO).get();
        instructor.setProfile(profile);
        instructorRepository.save(instructor);
    }

    @Override
    public void assignCourse(IdentificationInstructorDTO identificationInstructorDTO, IdentificationCourseDTO identificationCourseDTO) {
        Instructor instructor=this.findById(identificationInstructorDTO).get();
        Course course= courseRepository.findById(identificationCourseDTO.getId()).get();
        instructor.addCourse(course);
        this.save(instructor);
    }

    @Override
    public void update(IdentificationInstructorDTO identificationInstructorDTO, BasicInstructorDTO basicInstructorDTO) {
        Instructor instructor =this.getById(identificationInstructorDTO);
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


    @Override
    public void checkInstructor(BasicInstructorDTO instructor){
//        if (instructor.getLastName().length()==0)
//            throw new InvalidLastName();
//        if (instructor.getFirstName().length()==0)
//            throw new InvalidFirstName();
    }


}

