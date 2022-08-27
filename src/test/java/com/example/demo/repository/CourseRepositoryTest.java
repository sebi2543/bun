package com.example.demo.repository;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.apache.bcel.generic.FieldOrMethod;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RequiredArgsConstructor
public
class CourseRepositoryTest {

     @Autowired
     CourseRepository courseRepository;

    @Test
    @DisplayName("find like testing")
    void multiple_success_findByTileLike() {

        //given
        Course course=new Course("java");
        Course course2=new Course("java-beginner");
        Course course3=new Course("java-master");
        Course course4=new Course("javascript");
        Course course5=new Course("perl");
        Course course6=new Course("ruby");
        courseRepository.save(course);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);

        //when
        int result=courseRepository.findByTitleLike("java").get().size();

        //then
        Assertions.assertEquals(4,result,"the answer should be 4");
    }

    @Test
    @DisplayName("sorting course test")
    void findAllOrderByRating(){
        //given
        Course course1=new Course(2);
        Course course2=new Course(3);
        Course course3=new Course(1);
        Course course4=new Course(9);
        Course course5=new Course(10);
        Course course6=new Course(6);
        courseRepository.save(course1);
        courseRepository.save(course2);
        courseRepository.save(course3);
        courseRepository.save(course4);
        courseRepository.save(course5);
        courseRepository.save(course6);

        //when
        List<Integer> ratings=new ArrayList<>();
        List<Course> courses=courseRepository.findAllOrderByRating();
        for (Course course : courses){
                ratings.add(course.getRating());
        }

        //then
        Assertions.assertEquals(ratings, List.of(10, 9, 6, 3, 2, 1));
    }
}