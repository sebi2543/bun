package com.example.demo.service;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.repository.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class CourseServiceImplTest {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

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
    public void delete() {

        courseService.delete(1);
        courseService.delete(9);
        courseService.delete(5);

        Optional<Course> course1 =courseService.findById(1);
        Optional<Course> course2 =courseService.findById(9);
        Optional<Course> course3 =courseService.findById(5);

        Assertions.assertFalse(course1.isPresent());
        Assertions.assertFalse(course2.isPresent());
        Assertions.assertFalse(course3.isPresent());

        Assertions.assertEquals(courseService.getAll().size(),6);

    }

    @Test
    public void add(){
        courseService.add(new BasicCourseDTO("photoshop"));
        courseService.add(new BasicCourseDTO("marketing"));

        Assertions.assertEquals(11,courseService.getAll().size());
        Assertions.assertEquals("photoshop",courseService.getByTitle(new BasicCourseDTO("photoshop")).get(0).getTitle());
        Assertions.assertEquals("marketing",courseService.getByTitle(new BasicCourseDTO("marketing")).get(0).getTitle());
    }
    @Test
    public void update(){
        courseService.update(2,new BasicCourseDTO("modified1"));
        courseService.update(9,new BasicCourseDTO("modified2"));
        courseService.update(4,new BasicCourseDTO("modified3"));

        Assertions.assertEquals("modified1",courseService.getByTitle(new BasicCourseDTO("modified1")).get(0).getTitle());
        Assertions.assertEquals("modified2",courseService.getByTitle(new BasicCourseDTO("modified2")).get(0).getTitle());
        Assertions.assertEquals("modified3",courseService.getByTitle(new BasicCourseDTO("modified3")).get(0).getTitle());
    }

    @Test
    public void assignInstructor(){
        Instructor instructor1=new Instructor("JOHNSON","JOHN",1);
        Instructor instructor2=new Instructor("JIM","WALKER",6);
        instructorService.save(instructor1);
        instructorService.save(instructor2);
        courseService.assignInstructor(1,10);
        courseService.assignInstructor(2,11);
        Assertions.assertEquals(10,courseService.getById(1).getInstructor().id);
        Assertions.assertEquals(11,courseService.getById(2).getInstructor().id);
    }
    @Test
    public void giveGrade(){
        courseService.giveGrade(1,10);
        courseService.giveGrade(1,4);
        courseService.giveGrade(1,5);
        Assertions.assertEquals(19,courseService.getById(1).getSum());
        Assertions.assertEquals(3,courseService.getById(1).getHeadcount());
        Assertions.assertEquals(6.333333492279053,(float)courseService.getById(1).getRating());
    }

    @Test
    public void calculateAverage(){
        courseService.giveGrade(1,10);
        courseService.giveGrade(1,1);
        Assertions.assertEquals(5.5,courseService.calculateAverage(1));
    }


}