package com.example.demo;

import com.example.demo.controller.*;
import com.example.demo.entity.CourseTestIT;
import com.example.demo.entity.InstructorTestIT;
import com.example.demo.repository.CourseRepositoryTestIT;
import com.example.demo.repository.InstructorRepositoryTestIT;
import com.example.demo.service.CourseServiceImpl;
import com.example.demo.service.CourseServiceTestIT;
import com.example.demo.service.InstructorServiceTestIT;
import com.example.demo.service.ProfileTestIT;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
@Suite

@SelectClasses({InstructorRepositoryTestIT.class, CourseRepositoryTestIT.class, InstructorTestIT.class,
                CourseServiceImpl.class, InstructorServiceTestIT.class, ProfileTestIT.class,
                CourseTestIT.class, CourseServiceTestIT.class, CourseControllerTestEnd2End.class, ProfileControllerTestEnd2End.class,
                InstructorControllerTestEnd2End.class
})
class SuiteTest {

}