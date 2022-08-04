package com.example.demo.service;

import com.example.demo.entity.Instructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface InstructorRepositoryService {

    void save(Instructor instructor);
    List<Instructor> showAll();
    void delete(Instructor instructor);
    void populateDataBase();
    public Optional<Instructor> findById(int id);

}
