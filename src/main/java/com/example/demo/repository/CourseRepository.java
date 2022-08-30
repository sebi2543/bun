package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    List<Course>findByTitle(String title);

    @Query( value = "SELECT * FROM courses WHERE title LIKE %:title% ",nativeQuery = true)
    List<Course>findByTitleLike(String title);

    @Query( value = "SELECT * FROM courses ORDER BY rating DESC",nativeQuery = true)
    List<Course>findAllOrderByRating();

}
