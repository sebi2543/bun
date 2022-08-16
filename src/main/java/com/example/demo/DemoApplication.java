package com.example.demo;
import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.CourseRepositoryService;
import com.example.demo.service.InstructorRepositoryService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        CourseRepositoryService courseRepositoryService=context.getBean(CourseRepositoryService.class);
        InstructorRepositoryService instructorRepositoryService=context.getBean(InstructorRepositoryService.class);

        Instructor inst1=new Instructor("JOHN","SMITH");
        Instructor inst2=new Instructor("HARRY","KEAN");
        Instructor inst3=new Instructor("JOE","HARD");
        Instructor inst4=new Instructor("JACK","MILLER");

        instructorRepositoryService.save(inst1);
        instructorRepositoryService.save(inst2);
        instructorRepositoryService.save(inst3);
        instructorRepositoryService.save(inst4);

        Course course1=new Course("JAVA");
        Course course2=new Course("PYTHON");
        Course course3=new Course("RUBY");
        Course course4=new Course("GO");

        course1.setInstructor(inst1);
        course2.setInstructor(inst2);
        course3.setInstructor(inst3);
        course4.setInstructor(inst4);

        courseRepositoryService.save(course1);
        courseRepositoryService.save(course2);
        courseRepositoryService.save(course3);
        courseRepositoryService.save(course4);
    }
}