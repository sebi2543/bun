package com.example.demo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(DemoApplication.class, args);
		Course course1=new Course("JAVA");
		Course course2=new Course("HTML/CSS");
		Course course3=new Course("JS");
		Instructor instructor1 = new Instructor("JOHN","SMITH");
		Instructor instructor2 = new Instructor("JOHN","WALKER");
		Instructor instructor3 = new Instructor("JOHN","KAN");
		ArrayList<String> titles=new ArrayList<>();
		titles.add("JAVA");
		titles.add("PYTHON");
		titles.add("JS");
		titles.add("HTML");
		titles.add("CSS");
		titles.add("HTML/CSS");

//		-----------------------------------------------------------------------------------------
		CourseService courseService=context.getBean(CourseService.class);
		InstructorService instructorService =context.getBean(InstructorService.class);

		courseService.insertCourse(course1);
		courseService.insertCourse(course2);
		courseService.insertCourse(course3);

		instructorService.insertInstructor(instructor1);
		instructorService.insertInstructor(instructor2);
		instructorService.insertInstructor(instructor3);

		courseService.showCourses();
		instructorService.showInstructors();
	}

}


