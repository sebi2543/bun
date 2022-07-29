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

                ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
                CourseService courseService=context.getBean(CourseService.class);
                InstructorService instructorService=context.getBean(InstructorService.class);


                List<Instructor> instructors= Arrays.asList(
                        new Instructor("JOHN","SMITH",10),
                        new Instructor("JOHNNY","JOHNSON",5),
                        new Instructor("MICHAEL","SCOFIELD",4),
                        new Instructor("LINCOLN","BURROWS",9),
                        new Instructor("THEODOR","BAGWELL",9),
                        new Instructor("DEBY","COOPER",1)
                );
                for (Instructor instructor : instructors)
                        instructorService.save(instructor);

                List<Course> courses= Arrays.asList(
                        new Course("JAVA",instructors.get(0),8),
                        new Course("PHP",instructors.get(0),5),
                        new Course("JAVASCRIPT",instructors.get(0),10),
                        new Course("PERL",instructors.get(0),2),
                        new Course("GO",instructors.get(0),8),
                        new Course("HTML/CSS",instructors.get(0),2)
                );
                for (Course course:courses)
                        courseService.save(course);

               courseService.show();
               instructorService.show();



        }

        }