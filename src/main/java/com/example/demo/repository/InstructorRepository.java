package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {
    @Query( value = "SELECT * FROM instructors WHERE (first_name = :firstname OR last_name = :lastname)",nativeQuery = true)
    ArrayList<Instructor> findByFullName(String firstname,String lastname);
}
