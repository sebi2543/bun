package com.example.demo.controller;
import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CourseControllerTest {

    @Autowired
    CourseService courseService;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseController courseController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }
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

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
        courseService.save(course6);
        courseService.save(course5);
        courseService.save(course7);
        courseService.save(course8);
        courseService.save(course9);
    }
    @Test
    public void showMainPage_NonEmptyRepository_MultipleInstructors() throws Exception {
        mockMvc.perform(get("/course/all"))
                .andExpect(jsonPath("$",hasSize(9)));
    }
    @Test
    public void showSuitableCourses_Exist_Found() throws Exception {
        MvcResult mvcResult= mockMvc.perform(
                 get("/course/search"))
                .andReturn();
        System.err.println(mvcResult.getResponse().getContentAsString());
    }

}