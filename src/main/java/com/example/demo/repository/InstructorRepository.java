package com.example.demo.repository;

import com.example.demo.entity.Instructor;


import net.bytebuddy.matcher.MethodSortMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long>
{
  @Query(value = "SELECT * FROM instructors  WHERE instructor_id = :id", nativeQuery = true)
    Instructor findById(int  id);

  @Query(value = "SELECT * FROM instructors WHERE first_name = :firstName",nativeQuery = true)
  ArrayList<Instructor> findAllByFirstName(String firstName);

  @Query(value = "SELECT * FROM instructors WHERE last_name = :lastName",nativeQuery = true)
  ArrayList<Instructor> findAllByLastName(String lastName);

}
