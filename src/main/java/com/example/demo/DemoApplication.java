package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseRepositoryService;
import com.example.demo.service.InstructorRepositoryService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.List;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CourseRepositoryService courseRepositoryService=context.getBean(CourseRepositoryService.class);
        InstructorRepositoryService instructorRepositoryService=context.getBean(InstructorRepositoryService.class);


    }
}