package com.example.demo;
import com.example.demo.dto.InstructorDTO;
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
        InstructorMapper instructorMapper= context.getBean(InstructorMapper.class);

        Instructor instructor = new Instructor("Vasile","MURE");
        InstructorDTO instructorDTO =instructorMapper.InstructorToDTO(instructor);
        System.err.println(instructorDTO);

    }
}