package com.example.demo;
import com.example.demo.repository.CourseRepositoryTest;
import com.example.demo.repository.InstructorRepositoryTest;
import com.example.demo.service.CourseServiceImpl;
import com.example.demo.service.InstructorServiceImpl;
import com.example.demo.service.InstructorServiceImplTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTest.class, CourseRepositoryTest.class, CourseServiceImpl.class, InstructorServiceImplTest.class})
class SuiteTest {

}