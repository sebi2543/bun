package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.dto.IdentificationInstructorDTO;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidFirstName;
import com.example.demo.exception.InvalidIdInstructor;
import com.example.demo.exception.InvalidLastName;
import com.example.demo.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {


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

    @Override
    public List<Instructor> getAllOrderByRating() {
       return instructorRepository.findAllOrderByRating();
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
    public void delete(Instructor instructor) {
        instructorRepository.delete(instructor);
    }

    @Override
    public void checkId(IdentificationInstructorDTO identificationInstructorDTO) {
        Optional<Instructor> instructor=instructorRepository.findById(identificationInstructorDTO.getId());
        if (instructor.isEmpty())
            throw new InvalidIdInstructor();
    }

    @Override
    public void checkInstructor(BasicInstructorDTO instructor){
//        if (instructor.getLastName().length()==0)
//            throw new InvalidLastName();
//        if (instructor.getFirstName().length()==0)
//            throw new InvalidFirstName();
    }
}

