package com.example.demo.controller;

import com.example.demo.dto.BasicInstructorDTO;
import com.example.demo.entity.Course;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.Profile;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import com.example.demo.service.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.Assertions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
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
class InstructorControllerTestEnd2End {

    @Autowired
    InstructorRepository instructorRepository;
    @Autowired
    InstructorService instructorService;
    @Autowired
    ProfileService profileService;
    @Autowired
    CourseService courseService;
    @Autowired
    InstructorController instructorController;

    MockMvc mockMvc;
    ObjectMapper mapper;
    ObjectWriter ow;
    String requestJson;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(instructorController).build();
        mockMvc = MockMvcBuilders.standaloneSetup(instructorController).build();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ow = mapper.writer().withDefaultPrettyPrinter();
    }
    @BeforeEach
    void populateDB(){
        Instructor instructor1=new Instructor("john","smith",5);
        Instructor instructor2=new Instructor("david","kean",1);
        Instructor instructor3=new Instructor("david","kean",6);
        Instructor instructor4=new Instructor("hanna","walker",1);
        Instructor instructor5=new Instructor("johny","ferguson",2);
        Instructor instructor6=new Instructor("alexander","rooney",3);
        Instructor instructor7=new Instructor("dele","harrison",6);
        Instructor instructor8=new Instructor("joe","johnson",0);
        Instructor instructor9=new Instructor("pablo","scofield",8);

        Profile profile1=new Profile("newLinkedIn","newYoutube");
        Course course1=new Course("java");
        Course course2=new Course("python");

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
        courseService.save(course1);
        courseService.save(course2);
        courseService.assignInstructor(11,1);
        courseService.assignInstructor(12,1);
    }
    @Test
    @Transactional
    public void getCourse_NomEmpty_NotEmptyList() throws Exception {
        mockMvc.perform(get("/instructor/{1}/get-courses",1))
               .andExpect(status().is2xxSuccessful());
        List<Course> courses=courseService.getAll();
        for (Course course:courses)
            System.err.println(course.getInstructor());

        List<Instructor>instructors=instructorService.getAll();
        for (Instructor instructor:instructors)
            System.err.println(instructor.getCourses());

    }
    @Test
    void showMainPage_NonEmpty_NonEmptyList() throws Exception {
        mockMvc.perform(get("/instructor/all"))
               .andExpect(jsonPath("$",hasSize(9)));
    }

    @Test
    void add_SingleInstructor_Added() throws Exception {
        requestJson = ow.writeValueAsString(new Instructor("JOHN","SMITH"));
        mockMvc.perform(post("/instructor/add").contentType(APPLICATION_JSON_UTF8).content(requestJson))
               .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(10,instructorService.getAll().size());
    }

    @Test
    public void search_Single_Found() throws Exception {
        requestJson = ow.writeValueAsString(new BasicInstructorDTO("john","smith"));
        mockMvc.perform(get("/instructor/search").contentType(APPLICATION_JSON_UTF8).content(requestJson))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$",hasSize(1)))
               .andExpect(jsonPath("$[0].firstName",is("john")))
               .andExpect(jsonPath("$[0].lastName",is("smith")));
    }

    @Test
    public void search_Multiple_Found() throws Exception {
        requestJson = ow.writeValueAsString(new BasicInstructorDTO("david","kean"));
        mockMvc.perform(get("/instructor/search").contentType(APPLICATION_JSON_UTF8).content(requestJson))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$",hasSize(2)))
               .andExpect(jsonPath("$[0].lastName",is("kean")))
               .andExpect(jsonPath("$[1].firstName",is("david")))
               .andExpect(jsonPath("$[0].firstName",is("david")))
               .andExpect(jsonPath("$[1].lastName",is("kean")));
    }

    @Test
    public void showIdInstructor_Exist_Found() throws Exception {
        mockMvc.perform(get("/instructor/{id}",5).contentType(APPLICATION_JSON_UTF8))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$.firstName",is("johny")))
               .andExpect(jsonPath("$.lastName",is("ferguson")));
    }

    @Test
    public void deleteIdInstructor_Exist_Deleted() throws Exception {
        mockMvc.perform(delete("/instructor/{id}/delete",9).contentType(APPLICATION_JSON_UTF8))
               .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(8,instructorService.getAll().size());
    }

    @Test
    public void assignProfile_Exist_Assigned() throws Exception {
        requestJson = ow.writeValueAsString(10);
        mockMvc.perform(post("/instructor/{id}/assign-profile",7).contentType(APPLICATION_JSON_UTF8).content(requestJson))
               .andExpect(status().is2xxSuccessful());
    }

   @Test
   public void updateInstructor_Exist_Modified() throws Exception{
       requestJson = ow.writeValueAsString(new BasicInstructorDTO("newFirstName","newLastName"));
       mockMvc.perform(put("/instructor/{id}/update",3).contentType(APPLICATION_JSON_UTF8).content(requestJson))
              .andExpect(status().is2xxSuccessful());
       Assertions.assertEquals(instructorService.getById(3).getFirstName(),"newFirstName");
       Assertions.assertEquals(instructorService.getById(3).getLastName(),"newLastName");
   }

   @Test
    public void bestInstructor_Exist_Ordered ()throws Exception{
        mockMvc.perform(get("/instructor/best").contentType(APPLICATION_JSON_UTF8))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$[0].id",is(9)))
               .andExpect(jsonPath("$[3].id",is(1)))
               .andExpect(jsonPath("$[8].id",is(8)));
    }

    @Test
    public void showCourses_Exist_NonEmptyList()throws Exception{
        mockMvc.perform(get("/instructor/{id}/get-courses",1).contentType(APPLICATION_JSON_UTF8))
               .andExpect(status().is2xxSuccessful())
               .andExpect(jsonPath("$[0].title",is("java")))
               .andExpect(jsonPath("$[1].title",is("python")))
               .andExpect(jsonPath("$",hasSize(2)));
    }
}