package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import  com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class CourserServiceUnitTest {

     @Mock
     CourseRepository courseRepository;
     @Mock
     InstructorRepository instructorRepository;
     @Mock
     InstructorService instructorService;

     @Mock
     CourseMapper courseMapper;

     @InjectMocks
     CourseServiceImpl courseService;
     @Test
     public void save_OnlyTitleCourse_ServiceIsCalled(){
          Course course= new Course("JAVA");
          courseService.save(course);
          Mockito.verify(courseRepository).save(course);
     }

     @Test
     public void delete_OnlyTitleCourse_ServiceIsCalled(){
          Mockito.when(courseRepository.findById(any(Long.class))).thenReturn((Optional.of(new Course("JAVA"))));
          courseService.delete(1);
          Mockito.verify(courseRepository).delete(any());
          Mockito.verify(courseRepository).findById(1L);
     }

     @Test
     public void update_OnlyTitleCourse_ServiceIsCalled(){
          Mockito.when(courseRepository.findById(any())).thenReturn((Optional.of(new Course(1L))));
          courseService.update(1,new BasicCourseDTO("SPRING"));
          Mockito.verify(courseRepository).save(any(Course.class));
     }
     @Test
     public void assignInstructor_CourseWithoutInstructor_RepositoriesAreCalled() {
          Course course = new Course(1L);
          Mockito.when(courseRepository.findById(any())).thenReturn((Optional.of(course)));
          Mockito.when(instructorRepository.findById(any())).thenReturn((Optional.of(new Instructor(1L))));
          courseService.assignInstructor(1L, 1L);
          Mockito.verify(courseRepository).findById(1L);
          Mockito.verify(instructorRepository).findById(1L);
          Mockito.verify(courseRepository).save(course);
     }
     @Test
     public void add_OnlyTitleCourse_RepositoryIsCalled(){
          BasicCourseDTO courseDTO=new BasicCourseDTO("SPRING");
          Course course=new Course("SPRING");
          Mockito.when(courseMapper.toEntity(any())).thenReturn(course);
          courseService.add(courseDTO);
          Mockito.verify(courseRepository).save(course);
     }

     @Test
     public void showMainPAge_NonEmptyRepository_RepositoryIsCalled(){
          Mockito.when(courseRepository.findAll()).thenReturn(new ArrayList<>());
          courseService.showMainPage();
          Mockito.verify(courseRepository).findAll();
     }
}
