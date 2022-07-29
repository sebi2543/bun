package com.example.demo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorProfile;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorProfileService;
import com.example.demo.service.InstructorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

        public static void main(String[] args) {



                Instructor instructor = new Instructor("Tony","");

                ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
                CourseService courseService=context.getBean(CourseService.class);

//                courseService.show();


        }
}