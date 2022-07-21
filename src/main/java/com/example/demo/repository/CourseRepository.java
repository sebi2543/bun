package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {

    @Query( value = "SELECT * FROM courses WHERE course_id = :id",nativeQuery = true)
    Course findById(int id);

    @Query(value = "SELECT * FROM courses WHERE course_title = :title",nativeQuery = true)
    Course findByTitle(String title);

    @Query(value = "SELECT * FROM courses WHERE  course_title IN :titles ",nativeQuery = true)
    ArrayList<Course> findByAnyTitle(ArrayList<String> titles);

    @Modifying
    @Transactional
    @Query(value = "UPDATE courses SET course_title =:title WHERE course_id = :id ",nativeQuery = true)
    int updateTitle(String title,int id);
}
