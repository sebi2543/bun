package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Service
public class CourseRepositoryServiceImpl implements CourseRepositoryService{

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorRepositoryService instructorRepositoryService;

    public void save(Course course){
        courseRepository.save(course);
    }

    public void saveAll(List<Course> courses){
        courseRepository.saveAll(courses);
    }

    public void delete(Course course){
        courseRepository.delete(course);
    }

    public List<Course> showAll(){
        return courseRepository.findAll();
    }

   public Optional<Instructor> findById (int id){
      Optional<Instructor> instructor= instructorRepositoryService.findById(id);
      if (instructor.isPresent())
          return instructor;
      else
          throw  new IllegalArgumentException("NOT SUCH INSTRUCTOR");
   }

   public List<Course> findByTitle(String title){
        return courseRepository.findByTitle(title);
   }

   public List<Course>findSuggestion(String title){
        return courseRepository.findByTitleLike(title);
   }
}