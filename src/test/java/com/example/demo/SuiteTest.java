package com.example.demo;
import com.example.demo.repository.CourseRepositoryTest;
import com.example.demo.repository.InstructorRepositoryTest;
import com.example.demo.service.CourseServiceImpl;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTest.class, CourseRepositoryTest.class, CourseServiceImpl.class})
class SuiteTest {

}