package com.example.demo.controller;
import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {
    @Mock
    CourseService courseService;
    @Mock
    CourseMapper courseMapper;
    @Mock
    InstructorService instructorService;

    @InjectMocks
    CourseController courseController;

    MockMvc mockMvc;

    @BeforeEach
    void populateDB() {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
    }

    @Test
    public void showMainPage_NonEmptyRepository_NonEmptyList() throws Exception {

        List<Course> course = new ArrayList<>();
        course.add(new Course("java", 10));
        Mockito.when(courseService.getAll()).thenReturn(course);
        MvcResult mvcResult = this.mockMvc.perform(get("/course/all")).andReturn();
        String actualResponse = mvcResult.getResponse().getContentAsString();
        String expectedResponse = "[{\"id\":null,\"title\":\"java\",\"instructor\":null,\"rating\":10.0,\"headcount\":0,\"sum\":0}]";
        Assertions.assertEquals(expectedResponse, actualResponse);
    }
    @Test
    public void showSuitableCourses() throws Exception {
        List<BasicCourseDTO> course = new ArrayList<>();
        course.add(new BasicCourseDTO("PROGRAMMING"));
        Mockito.when(courseService.showSuitableCourses(any())).thenReturn(course);
        this.mockMvc
            .perform(post("/course/search")
            .content("{ \"title\":\"PROGRAMMING\"}")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(( jsonPath("$.title").value("PROGRAMMING")));


    }
}