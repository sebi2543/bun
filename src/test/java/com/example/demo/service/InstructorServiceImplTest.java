package com.example.demo.service;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.repository.InstructorRepository;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class InstructorServiceImplTest {

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    InstructorService instructorService;

    @Autowired
    ProfileService profileService;

    @Autowired
    CourseService courseService;
    @BeforeEach
    public void populateDB(){
        Instructor instructor1=new Instructor("john","smith",5);
        Instructor instructor2=new Instructor("david","kean",1);
        Instructor instructor3=new Instructor("david","kean",6);
        Instructor instructor4=new Instructor("hanna","walker",1);
        Instructor instructor5=new Instructor("johny","ferguson",2);
        Instructor instructor6=new Instructor("alexander","rooney",3);
        Instructor instructor7=new Instructor("dele","harrison",6);
        Instructor instructor8=new Instructor("joe","johnson",1);
        Instructor instructor9=new Instructor("pablo","scofield",8);

        Profile profile1=new Profile("JOHNlinkedin","JOHNyoutube");
        Profile profile2=new Profile("DAVIDlinkedin","DAVIDyoutube");
        Profile profile3=new Profile("Linkedin","youtube");

        Course course1=new Course("html");
        Course course2=new Course("css");
        Course course3=new Course("javascript");

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);
        instructorRepository.save(instructor7);
        instructorRepository.save(instructor8);
        instructorRepository.save(instructor9);

        profileService.save(profile1);
        profileService.save(profile2);
        profileService.save(profile3);

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);

    }

    @Test
    public void delete_MultipleInstructors_InstructorsAreDeleted(){
        instructorService.delete(1);
        instructorService.delete(7);
        instructorService.delete(5);

        Assertions.assertThrows(InvalidParameterException.class,()->{
            instructorService.getById(1);
        });

        Assertions.assertThrows(InvalidParameterException.class,()->{
            instructorService.getById(7);
        });
        Assertions.assertThrows(InvalidParameterException.class,()->{
            instructorService.getById(5);
        });
        assertEquals(6,instructorService.getAll().size());
    }

    @Test
    public void assignProfile_MultipleProfiles_ProfilesAreAssign(){
        instructorService.assignProfile(1,10);
        instructorService.assignProfile(2,11);
        instructorService.assignProfile(3,12);

        Assertions.assertAll(
        ()-> Assertions.assertEquals(11,instructorService.getById(2).getProfile().getId()),
        ()-> Assertions.assertEquals(12,instructorService.getById(3).getProfile().getId()),
        ()-> Assertions.assertEquals(10,instructorService.getById(1).getProfile().getId())
    );
    }

    @Test
    public void update_SingleInstructor_InstructorIsModified(){
        instructorService.update(1,new BasicInstructorDTO("lewis","hamilton"));

        Assertions.assertAll(
        ()->assertEquals("lewis",instructorService.getById(1).getFirstName()),
        ()->assertEquals("hamilton",instructorService.getById(1).getLastName())
        );
    }

    @Test
    public void add_MultipleInstructors_InstructorsAreAdded(){
        instructorService.add(new BasicInstructorDTO("michale","stan"));
        instructorService.add(new BasicInstructorDTO("michale","stan"));
        Assertions.assertAll(
        ()->assertEquals( 2,instructorService.getByFullName((new BasicInstructorDTO("michale","stan"))).size()),
        ()->assertEquals(11,instructorService.getAll().size())
    );
    }

    @Test
    public void showAll_NonEmptyRepo_NonEmptyList(){
        assertEquals(9,instructorService.showAll().size());
    }

    @Test
    public void showSuitableInstructors_DifferentInstructorsWithTheSameName_MultipleAppears(){
       List<BasicInstructorDTO>instructors = instructorService.showSuitableInstructors(new BasicInstructorDTO("david","kean"));
        Assertions.assertAll(
        ()->assertEquals(2,instructors.size()),
        ()->assertEquals("david",instructors.get(0).getFirstName()),
        ()->assertEquals("kean",instructors.get(0).getLastName())
    );
    }
}