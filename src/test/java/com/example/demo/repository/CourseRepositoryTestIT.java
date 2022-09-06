package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class CourseRepositoryTestIT {

    @Autowired
   CourseRepository courseRepository;

    @BeforeEach
    void populateDB(){
        Course course1=new Course("java",5);
        Course course2=new Course("python",1);
        Course course3=new Course("ruby",9);
        Course course4=new Course("html",9);
        Course course5=new Course("c++",4);
        Course course6=new Course("matlab",3);
        Course course7=new Course("javascript",8);
        Course course8=new Course("python",7);
        Course course9=new Course("java",2);

        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);
        courseRepository.save(course7);
        courseRepository.save(course8);
        courseRepository.save(course9);
    }

    @Test
    public void findByTitle_nonEmpty_NonEmptyList(){
        List<Course> courses=courseRepository.findByTitle("java");
        Assertions.assertEquals(2,courses.size());
        Assertions.assertEquals(1,courses.get(0).getId());
        Assertions.assertEquals(9,courses.get(1).getId());
    }
    @Test
    public void findByTitle_Empty_EmptyList(){
        List<Course>courses=courseRepository.findByTitle("c");
        Assertions.assertEquals(0,courses.size());
    }

    @Test
    public void findByTitleLike_nonEmpty_NonEmptyList(){
        List<Course> courses=courseRepository.findByTitleLike("java");
        Assertions.assertEquals(3,courses.size());
        Assertions.assertEquals(1,courses.get(0).getId());
        Assertions.assertEquals(7,courses.get(1).getId());
        Assertions.assertEquals(9,courses.get(2).getId());
    }

    @Test
    public void findByTitleLike_Empty_EmptyList(){
        List<Course> courses=courseRepository.findByTitleLike(".net");
        Assertions.assertEquals(0,courses.size());
    }
    @Test
   public void findAllOrderByRating_MixedValues_OrderedList() {
        List<Course>courses=courseRepository.findAllOrderByRating();
        List<Float>ratings=new ArrayList<>();
        for (Course course:courses)
            ratings.add(course.getRating());
        Assertions.assertEquals(ratings,List.of((float)9.0,(float) 9.0,(float) 8.0, (float)7.0,
                                        (float)5.0,(float) 4.0, (float)3.0, (float)2.0, (float)1.0));
   }

}