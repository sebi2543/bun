package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor,Long> {

  List<Instructor>findByFirstNameAndLastName(String firstName, String lastName);

   @Query( value = "SELECT * FROM instructors ORDER BY rating DESC",nativeQuery = true)
   List<Instructor>findAllOrderByRating();
}
