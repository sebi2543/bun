package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface InstructorProfileRepository extends JpaRepository<InstructorProfile,Long> {
}



