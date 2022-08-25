package com.example.demo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.service.CourseService;
import com.example.demo.service.ProfileService;
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
        ProfileService profileService =context.getBean(ProfileService.class);

        Instructor inst1=new Instructor("JOHN","SMITH");
        Instructor inst2=new Instructor("HARRY","KEAN");
        Instructor inst3=new Instructor("JOE","HARD");
        Instructor inst4=new Instructor("JACK","MILLER");
        inst1.setRating(9);
        inst2.setRating(1);
        inst3.setRating(7);
        inst4.setRating(4);


        instructorService.save(inst1);
        instructorService.save(inst2);
        instructorService.save(inst3);
        instructorService.save(inst4);

        Course course1=new Course("JAVA");
        course1.setRating(10);
        Course course2=new Course("PYTHON");
        course2.setRating(1);
        Course course3=new Course("RUBY");
        course3.setRating(6);
        Course course4=new Course("GO");
        course4.setRating(8);

        Profile profile1 =new Profile("johnyoutub","johnlinkedin");
        Profile profile2 =new Profile("harryyoutub","harrylinkedin");
        Profile profile3 =new Profile("joeyoutub","joelinkedin");
        Profile profile4 =new Profile("jackyoutub","jacklinkedin");

        profileService.save(profile1);
        profileService.save(profile2);
        profileService.save(profile3);
        profileService.save(profile4);

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
    }
}