package com.example.demo;
import com.example.demo.repository.InstructorRepositoryTest;
import com.example.demo.service.CourseServiceImplTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTest.class, CourseServiceImplTest.class})
class SuiteTest {

}