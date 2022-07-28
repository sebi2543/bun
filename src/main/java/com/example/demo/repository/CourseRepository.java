package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query( value = "SELECT * FROM courses WHERE course_id = :id",nativeQuery = true)
    Course findById(int id);

    public List<Course> findByRatingGreaterThan(int x);

}
