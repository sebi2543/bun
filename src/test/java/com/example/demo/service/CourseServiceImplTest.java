package com.example.demo.service;
import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseServiceImplTest {

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;
    @Test
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
    public void assignInstructor(){

        Course course1=new Course("typescript",8);
        Course course2=new Course("css",8);
        Course course3=new Course("html",8);

        Instructor instructor1 = new Instructor(1);
        Instructor instructor2 = new Instructor(10);
        Instructor instructor3 = new Instructor(8);

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