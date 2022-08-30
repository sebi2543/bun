package com.example.demo.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class InstructorTest {

    @Test
    public  void add(){
        Instructor instructor=new Instructor("JOHN","SMITH",8);
        instructor.addCourse(new Course("HTML"));
        assertEquals(1,instructor.getCourses().size());
    }


}