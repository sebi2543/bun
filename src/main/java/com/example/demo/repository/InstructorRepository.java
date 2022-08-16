package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

    ArrayList<Instructor>findByFirstNameAndLastName(String firstName,String lastName);
}
