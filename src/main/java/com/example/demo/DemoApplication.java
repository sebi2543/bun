package com.example.demo;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.ProfileService;
import com.example.demo.service.InstructorService;
import org.checkerframework.checker.units.qual.C;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args)  {
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        UserRepository userRepository=context.getBean(UserRepository.class);
        CourseService courseService=context.getBean(CourseService.class);
        User user=new User("ana","pass");
        user.setActive(true);
        userRepository.save(user);
//        CourseService courseService =context.getBean(CourseService.class);
        InstructorService instructorService =context.getBean(InstructorService.class);
//        ProfileService profileService =context.getBean(ProfileService.class);
//
        Instructor inst1=new Instructor("JOHN","SMITH");
        Instructor inst2=new Instructor("HARRY","KEAN");
        Instructor inst3=new Instructor("JOE","HARD");
        Instructor inst4=new Instructor("JACK","MILLER");
//        inst1.setRating(9);
//        inst2.setRating(1);
//        inst3.setRating(7);
//        inst4.setRating(4);
//
//
        instructorService.save(inst1);
        instructorService.save(inst2);
        instructorService.save(inst3);
        instructorService.save(inst4);
//
        Course course1=new Course("JAVA","oftogies ofg thir dediode on users' devices.");
        course1.setRating(10);
        Course course2=new Course("PYTHON","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course2.setRating(1);
        Course course3=new Course("RUBY","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course3.setRating(6);
        Course course4=new Course("GO","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course4.setRating(8);
        Course course5=new Course("photo","Pyogramming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course5.setRating(9);
        Course course6=new Course("camera","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course6.setRating(7);


        Course course7=new Course("ABAP","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course7.setRating(1);
        Course course8= new Course("HTML","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course8.setRating(4);
        Course course9=new Course("CSS","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course9.setRating(4);
        Course course10=new Course("JSS","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course10.setRating(6);
        Course course11= new Course("TypeScript","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course11.setRating(7);
        Course course12=new Course("pascal","Python is a high-level, general-purpose programming language. Its design philosophy emphasizes code readability with the use of significant indentation");
        course12.setRating(9);


//
//        Profile profile1 =new Profile(null, "johnyoutub","johnlinkedin");
//        Profile profile2 =new Profile(null, "harryyoutub","harrylinkedin");
//        Profile profile3 =new Profile(null, "joeyoutub","joelinkedin");
//        Profile profile4 =new Profile(null, "jackyoutub","jacklinkedin");
//
//        profileService.save(profile1);
//        profileService.save(profile2);
//        profileService.save(profile3);
//        profileService.save(profile4);
//
        course1.setInstructor(inst1);
        course2.setInstructor(inst2);
        course3.setInstructor(inst3);
        course4.setInstructor(inst4);
        course5.setInstructor(inst4);
        course6.setInstructor(inst3);
        course7.setInstructor(inst2);
        course8.setInstructor(inst1);
        course9.setInstructor(inst2);
        course10.setInstructor(inst3);
        course11.setInstructor(inst4);
        course12.setInstructor(inst1);

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
        courseService.save(course5);
        courseService.save(course6);
        courseService.save(course7);
        courseService.save(course8);
        courseService.save(course9);
        courseService.save(course10);
        courseService.save(course11);
        courseService.save(course12);

        System.out.println(course1.getInstructorName());
    }
}