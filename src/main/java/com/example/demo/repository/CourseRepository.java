package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

//    @Query( value = "SELECT * FROM courses WHERE title = :title",nativeQuery = true)
    List<Course> findByTitle(String title);

//    @Query( value = "SELECT * FROM courses WHERE title LIKE %:title%",nativeQuery = true)
    List<Course> findByTitleLike(String title);
}
