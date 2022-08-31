package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.InstructorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.OptionalInt;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class CourserServiceUnitTest {

     @Mock
     CourseRepository courseRepository;
     @Mock
     InstructorRepository instructorRepository;

     @InjectMocks
     CourseServiceImpl courseService;
     @Test
     public void save(){
          Course course= new Course("JAVA");
          course.setId(1L);
          Mockito.doReturn(true).when(courseRepository).save(course);
          courseService.save(course);
          Mockito.verify(courseRepository).save(course);
     }
}
