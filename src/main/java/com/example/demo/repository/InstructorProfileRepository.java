package com.example.demo.repository;

import com.example.demo.entity.InstructorProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorProfileRepository extends JpaRepository<InstructorProfile,Long> {
}
