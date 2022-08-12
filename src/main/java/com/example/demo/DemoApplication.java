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


        instructorRepositoryService.save(new Instructor("JOHN","SMITH"));
        instructorRepositoryService.save(new Instructor("HARRY","KEAN"));
        instructorRepositoryService.save(new Instructor("JOE","HARD"));
        instructorRepositoryService.save(new Instructor("JACK","MILLER"));

        courseRepositoryService.save(new Course("JAVA"));
        courseRepositoryService.save(new Course("PYTHON"));
        courseRepositoryService.save(new Course("RUBY"));
        courseRepositoryService.save(new Course("GO"));

    }
}