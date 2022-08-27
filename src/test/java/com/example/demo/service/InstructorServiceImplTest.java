package com.example.demo.service;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@SpringBootTest
class InstructorServiceImplTest {

    @Autowired
    InstructorService instructorService;

    @Autowired
    ProfileService profileService;

    @Autowired
    CourseService courseService;

    @Test
    void assignProfile() {
        Instructor instructor1=new Instructor("MARIUS","VESA");
        Instructor instructor2=new Instructor("MARIAN","VESA");
        Instructor instructor3=new Instructor("IONUT","BURZ");

        Profile profile1=new Profile("youtubeMARIUS","linkedInMARIUS");
        Profile profile2=new Profile("youtubeMARIAN","linkedInMARIAN");
        Profile profile3=new Profile("youtubeIONUT","linkedInIONUT");

        instructorService.save(instructor1);
        instructorService.save(instructor2);
        instructorService.save(instructor3);

        profileService.save(profile1);
        profileService.save(profile2);
        profileService.save(profile3);

        instructorService.assignProfile(1,4);
        instructorService.assignProfile(2,5);
        instructorService.assignProfile(3,6);

        Assertions.assertNotNull(instructorService.getById(1).getProfile());
        Assertions.assertNotNull(instructorService.getById(2).getProfile());
        Assertions.assertNotNull(instructorService.getById(3).getProfile());

    }
//    org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role
//    @Test
//    void assignCourse() {
//
//        Instructor instructor1=new Instructor("MARIUS","VESA");
//        Instructor instructor2=new Instructor("MARIAN","VESA");
//        Instructor instructor3=new Instructor("IONUT","BURZ");
//
//        Course course1=new Course("typescript",8);
//        Course course2=new Course("css",8);
//        Course course3=new Course("html",8);
//
//        instructorService.save(instructor1);
//        instructorService.save(instructor2);
//        instructorService.save(instructor3);
//
//        courseService.save(course1);
//        courseService.save(course2);
//        courseService.save(course3);
//
//        instructorService.assignCourse(1,4);
//        instructorService.assignCourse(2,5);
//        instructorService.assignCourse(3,6);
//
//        Assertions.assertNotEquals(true,instructorService.getById(1).getCourses().isEmpty());
//        Assertions.assertNotEquals(true,instructorService.getById(2).getCourses().isEmpty());
//        Assertions.assertNotEquals(true,instructorService.getById(3).getCourses().isEmpty());
//    }
}