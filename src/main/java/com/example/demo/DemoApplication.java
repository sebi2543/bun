package com.example.demo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CourseService courseService =context.getBean(CourseService.class);
        InstructorService instructorService =context.getBean(InstructorService.class);

        Instructor inst1=new Instructor("JOHN","SMITH");
        Instructor inst2=new Instructor("HARRY","KEAN");
        Instructor inst3=new Instructor("JOE","HARD");
        Instructor inst4=new Instructor("JACK","MILLER");

        instructorService.save(inst1);
        instructorService.save(inst2);
        instructorService.save(inst3);
        instructorService.save(inst4);

        Course course1=new Course("JAVA");
        Course course2=new Course("PYTHON");
        Course course3=new Course("RUBY");
        Course course4=new Course("GO");


        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
    }
}