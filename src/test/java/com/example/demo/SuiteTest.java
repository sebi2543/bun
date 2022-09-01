package com.example.demo;

import com.example.demo.entity.CourseTest;
import com.example.demo.entity.InstructorTest;
import com.example.demo.repository.CourseRepositoryTest;
import com.example.demo.repository.InstructorRepositoryTest;
import com.example.demo.service.CourseServiceImpl;
import com.example.demo.service.CourseServiceImplTest;
import com.example.demo.service.InstructorServiceImplTest;
import com.example.demo.service.ProfileImplTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTest.class, CourseRepositoryTest.class, InstructorTest.class,
                CourseServiceImpl.class, InstructorServiceImplTest.class, ProfileImplTest.class,
                CourseTest.class, CourseServiceImplTest.class
})
class SuiteTest {

}