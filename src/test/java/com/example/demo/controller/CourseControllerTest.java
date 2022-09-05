package com.example.demo.controller;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.NestedServletException;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class CourseControllerTest {

    @Autowired
    CourseService courseService;
    @Autowired
    InstructorService instructorService;
    @Autowired
    CourseController courseController;

    ObjectMapper mapper;
    ObjectWriter ow;
    String requestJson;

     MockMvc mockMvc;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(courseController).build();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ow = mapper.writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    void populateDB() {
        Course course1 = new Course("java", 5);
        Course course2 = new Course("python", 1);
        Course course3 = new Course("ruby", 9);
        Course course4 = new Course("html", 6);
        Course course5 = new Course("c++", 4);
        Course course6 = new Course("matlab", 3);
        Course course7 = new Course("javascript", 8);
        Course course8 = new Course("python", 7);
        Course course9 = new Course("java", 2);
        course9.addGrade(10);
        course9.addGrade(2);

        courseService.save(course1);
        courseService.save(course2);
        courseService.save(course3);
        courseService.save(course4);
        courseService.save(course5);
        courseService.save(course6);
        courseService.save(course7);
        courseService.save(course8);
        courseService.save(course9);

        Instructor instructor1=new Instructor("JOHN","SMITH",5);
        instructorService.save(instructor1);
    }

    @Test
    public void showMainPage_NonEmptyRepository_MultipleInstructors() throws Exception {
        mockMvc.perform(get("/course/all"))
                .andExpect(jsonPath("$", hasSize(9)));
    }

    @Test
    public void showSuitableCourses_Exist_Found() throws Exception {
        requestJson = ow.writeValueAsString(new Course("java"));
        mockMvc.perform(get("/course/search").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title", is("java")))
                .andExpect(jsonPath("$[1].title", is("java")));
    }

    @Test
    public void showSuitableCourses_NotExist_NotFound() throws Exception {
        requestJson = ow.writeValueAsString(new Course(".net"));
        mockMvc.perform(get("/course/search").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void showAutoSuggestion_Exist_Found() throws Exception {
        requestJson = ow.writeValueAsString(new Course("java"));
        mockMvc.perform(get("/course/suggestion").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(jsonPath("$[0].title", is("java")))
                .andExpect(jsonPath("$[1].title", is("javascript")))
                .andExpect(jsonPath("$[2].title", is("java")))
                .andExpect(jsonPath("$", hasSize(3)));
    }

    @Test
    public void showAutoSuggestion_NotExist_NotFound() throws Exception {
        requestJson = ow.writeValueAsString(new Course("photoshop"));
        mockMvc.perform(get("/course/suggestion").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void showIdCourse_Exist_Found() throws Exception {
        mockMvc.perform(get("/course/{id}", "6").contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.title", is("matlab")));
    }

    @Test
    public void showIdCourse_NotExist_NotFound() throws Exception {
        try {
            mockMvc.perform(get("/course/{id}", "12").contentType(APPLICATION_JSON_UTF8));
            assertFalse(true);
        }
        catch (NestedServletException exception) {
            assertTrue(true);
        }
    }

    @Test
    public void addCourse_SingleCourse_Added() throws Exception {
        requestJson = ow.writeValueAsString(new Course("spring"));
        mockMvc.perform(post("/course/add").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(courseService.getAll().size(),10);
        Assertions.assertEquals(courseService.getById(11).getTitle(),"spring");
    }
    @Test
    public void updateCourse_SingleCourse_Modified() throws Exception {
        requestJson = ow.writeValueAsString(new Course("spring"));
        mockMvc.perform(put("/course/{id}/update","5").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(courseService.getById(5).getTitle(),"spring");
    }
    @Test
    public void deleteCourse_SingleCourse_Deleted() throws Exception {
        requestJson = ow.writeValueAsString(new Course("spring"));
        mockMvc.perform(delete("/course/{id}/delete","1").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(courseService.getAll().size(),8);
    }

    @Test
    public void best_MixedRatings_Ordered() throws Exception {

        mockMvc.perform(get("/course/best").contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].title", is("ruby")))
                .andExpect(jsonPath("$[8].title", is("python")));
    }

    @Test
    public void giveGrade_LowValue_CorrectAverage() throws Exception {
        requestJson = ow.writeValueAsString(3);
        mockMvc.perform(post("/course/{id}/give-grade",1).contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(1,courseService.getById(1).getHeadcount());
        Assertions.assertEquals(3,courseService.getById(1).getSum());
        Assertions.assertEquals(3,courseService.getById(1).getRating());
    }

    @Test
    public void giveGrade_HighValue_CorrectAverage() throws Exception {
        requestJson = ow.writeValueAsString(9);
        mockMvc.perform(post("/course/{id}/give-grade",1).contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(1,courseService.getById(1).getHeadcount());
        Assertions.assertEquals(9,courseService.getById(1).getSum());
        Assertions.assertEquals(9,courseService.getById(1).getRating());
    }

    @Test
    public void calculateAverage_SingleAverage_Success() throws Exception {
        mockMvc.perform(get("/course/{id}/average",9).contentType(APPLICATION_JSON_UTF8));
        Assertions.assertEquals(6,courseService.calculateAverage(9));
    }

    @Test
    @Transactional
    public void assignInstructor_SingleInstructor_Added() throws Exception {
        requestJson = ow.writeValueAsString(10);
        mockMvc.perform(post("/course/{id}/assign-instructor",3).contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(courseService.getById(3).getInstructor().getId(),10);
    }
}