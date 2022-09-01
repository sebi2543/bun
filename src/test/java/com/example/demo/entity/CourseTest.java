package com.example.demo.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {

    Course course;

    @BeforeEach
    public void setUp() {
        course=new Course();
    }

    @Test
    void addGrade_MixedValues_CorrectAverage() {
        course.addGrade(7);
        course.addGrade(9);
        course.addGrade(1);
        course.addGrade(6);
        assertEquals(23,course.getSum());
        assertEquals(4,course.getHeadcount());
        assertEquals(5.75,course.getRating());
    }
}