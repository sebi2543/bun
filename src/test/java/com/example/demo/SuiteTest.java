package com.example.demo;
import com.example.demo.repository.CourseRepositoryTest;
import com.example.demo.repository.InstructorRepositoryTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTest.class, CourseRepositoryTest.class})
class SuiteTest {

}