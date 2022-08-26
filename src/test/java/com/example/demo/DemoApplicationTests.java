package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	CourseRepository courseRepository;
	@Test
	void multiple_success_findByTileLike() {
		//given
		Course course=new Course("java");
		Course course2=new Course("java-beginer");
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
		Assertions.assertEquals(4,result);
	}


}
