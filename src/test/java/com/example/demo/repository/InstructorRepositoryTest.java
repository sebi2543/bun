package com.example.demo.repository;
import com.example.demo.entity.Instructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("sorting instructor testing")
    public void findAllOrderByRating(){
        //given
        Instructor instructor1 = new Instructor(1);
        Instructor instructor2 = new Instructor(10);
        Instructor instructor3 = new Instructor(8);
        Instructor instructor4 = new Instructor(5);
        Instructor instructor5 = new Instructor(3);
        Instructor instructor6 = new Instructor(9);
        Instructor instructor7 = new Instructor(2);
        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);
        instructorRepository.save(instructor3);
        instructorRepository.save(instructor4);
        instructorRepository.save(instructor5);
        instructorRepository.save(instructor6);
        instructorRepository.save(instructor7);

        //when
        List<Instructor> instructors=instructorRepository.findAllOrderByRating();
        List<Integer> ratings=new ArrayList<>();
        for (Instructor instructor:instructors){
            ratings.add(instructor.getRating());
        }

        //then
        Assertions.assertEquals(ratings,List.of(10,9,8,5,3,2,1));
    }


}