package com.example.demo.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class InstructorTestIT {

    Instructor instructor=new Instructor("JOHN","SMITH");

    @BeforeEach
    void setUp(){
        Course course1=new Course("JAVA");
        course1.setRating(9);

        Course course2=new Course("JAVA");
        course2.setRating(7);
        instructor.getCourses().add(course1);
        instructor.getCourses().add(course2);
    }

    @Test
    public void calculateRating(){
        float average=instructor.calculateRating();
        Assertions.assertEquals(8,average);
    }

}