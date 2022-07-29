package com.example.demo.repository;

import com.example.demo.entity.Instructor;


import net.bytebuddy.matcher.MethodSortMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor,Long>
{
  @Query(value = "SELECT * FROM instructors  WHERE instructor_id = :id", nativeQuery = true)
    Instructor findById(int  id);

  @Query(value = "SELECT * FROM instructors ORDER BY rating DESC",nativeQuery = true)
  ArrayList<Instructor> selectTheBestInstructors();
  @Query(value = "SELECT * FROM instructors WHERE firstname = :firstname OR lastname= :lastname ",nativeQuery = true)
  ArrayList<Instructor> findByFirstnameOrLastname(String firstname,String lastname);
}

