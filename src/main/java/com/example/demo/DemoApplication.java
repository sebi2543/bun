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
        Course course1 = new Course("JAVA");
        Course course2 =new Course("PYTHON");
        Course course3 =new Course("JAVASCRIPT");

        Instructor instructor1= new Instructor("MARIAN","VESA");
        Instructor instructor2= new Instructor("IONUT","BURZ");
        Instructor instructor3= new Instructor("CALIN","SICOE");

        InstructorProfile instructorProfile1= new InstructorProfile("marianlinkedin","marianyoutube");
        InstructorProfile instructorProfile2= new InstructorProfile("ionutlinkedin","ionutyoutube");
        InstructorProfile instructorProfile3= new InstructorProfile("calinlinkedin","calinyoutube");
        ArrayList<Course> courses1=new ArrayList<>();
        courses1.add(course1);
        courses1.add(course2);

        ArrayList<Course> courses2=new ArrayList<>();
        courses1.add(course1);
        courses1.add(course3);

        ArrayList<Course> courses3=new ArrayList<>();
        courses1.add(course2);
        courses1.add(course3);


//        -------------------------------------------------------------------------
		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
        CourseService courseService=context.getBean(CourseService.class);
        InstructorService instructorService=context.getBean(InstructorService.class);
        InstructorProfileService instructorProfileService=context.getBean(InstructorProfileService.class);

        instructor1.setInstructorProfile(instructorProfile1);
        instructor2.setInstructorProfile(instructorProfile2);
        instructor3.setInstructorProfile(instructorProfile3);

        instructor1.setCourses(courses1);
        instructor2.setCourses(courses2);
        instructor3.setCourses(courses3);

        instructorService.insertInstructor(instructor1);
        instructorService.insertInstructor(instructor2);
        instructorService.insertInstructor(instructor3);

        instructorService.showInstructors();


	}

}


