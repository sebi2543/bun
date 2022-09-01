package com.example.demo.repository;

import com.example.demo.entity.Instructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class InstructorRepositoryTest {

    @Autowired
    InstructorRepository instructorRepository;

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

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);
        instructorRepository.save(instructor7);
        instructorRepository.save(instructor8);
        instructorRepository.save(instructor9);
    }
    @Test
    void findByFirstNameAndLastName_Exist_Found() {
       List<Instructor> instructors1 = instructorRepository.findByFirstNameAndLastName("john","smith");
       List<Instructor> instructors2 = instructorRepository.findByFirstNameAndLastName("david","kean");

       Assertions.assertEquals(1,instructors1.size());
       Assertions.assertEquals(1,instructors1.get(0).getId());

       Assertions.assertEquals(2,instructors2.size());
       Assertions.assertEquals(2,instructors2.get(0).getId());
       Assertions.assertEquals(3,instructors2.get(1).getId());
    }

    @Test
    void findByFirstNameAndLastName_Missing_NotFound() {
        List<Instructor> instructors1 = instructorRepository.findByFirstNameAndLastName("john","johnson");
        Assertions.assertEquals(0,instructors1.size());
    }

    @Test
    void findAllOrderByRating_MixedValues_OrderedList() {
        List<Instructor>instructors=instructorRepository.findAllOrderByRating();
        List<Float>ratings=new ArrayList<>();
        for (Instructor instructor:instructors)
            ratings.add(instructor.getRating());
        Assertions.assertEquals(ratings,List.of((float)8,(float)6,(float)6,(float)5,(float)3,(float)2,(float)1,(float)1,(float)1));
    }
}