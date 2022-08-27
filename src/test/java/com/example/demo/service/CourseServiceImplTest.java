package com.example.demo.service;
import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
public
class CourseServiceImplTest {

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    public void clean(){
        courseRepository.deleteAll();
    }

    @Test
    @DisplayName("update course testing")
    public void update(){
        //given
        Course course1=new Course("typescript",8);
        Course course2=new Course("css",8);
        Course course3=new Course("html",8);
        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);

        //when
        courseService.update(1,new BasicCourseDTO("java"));
        courseService.update(2,new BasicCourseDTO("GO"));
        courseService.update(3,new BasicCourseDTO("XML"));
        //then
        Assertions.assertEquals(courseService.getById(1).getTitle(),"java");
        Assertions.assertEquals(courseService.getById(2).getTitle(),"GO");
        Assertions.assertEquals(courseService.getById(3).getTitle(),"XML");
    }
    @Test
    @DisplayName("assign instructor testing")
    public void assignInstructor(){

        Course course1=new Course("python",1);
        Course course2=new Course("ruby",8);
        Course course3=new Course("c++",8);

        Instructor instructor1 = new Instructor("MARIAN","VESA");
        Instructor instructor2 = new Instructor("MARIUS","VESA");
        Instructor instructor3 = new Instructor("EU","EU");

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);

        instructorService.save(instructor1);
        instructorService.save(instructor2);
        instructorService.save(instructor3);

        courseService.assignInstructor(1,4);
        courseService.assignInstructor(2,5);
        courseService.assignInstructor(3,6);

        Assertions.assertNotNull(courseService.getById(1).getInstructor());
        Assertions.assertNotNull(courseService.getById(2).getInstructor());
        Assertions.assertNotNull(courseService.getById(3).getInstructor());

    }


}