package com.example.demo.service;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.exception.InvalidTitle;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseMapper courseMapper;
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
      Optional<Instructor> instructor= instructorService.findById(id);
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


    public  void checkTitle(String title) throws InvalidTitle {
        if (title.length()==0)
            throw new InvalidTitle();
        if (title.length()>1 && title.length()<=3)
            throw  new InvalidTitle();
    }

    public List<CourseDTO>CourseToDOS(List<Course> courses) {
        List<CourseDTO> courseDTOS=new ArrayList<>();
        for (Course course : courses)
            courseDTOS.add(courseMapper.courseToDTO(course));
        return courseDTOS;
    }
}