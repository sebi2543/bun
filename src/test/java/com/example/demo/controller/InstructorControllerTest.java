package com.example.demo.controller;

import com.example.demo.entity.Instructor;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import com.example.demo.service.ProfileService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class InstructorControllerTest {

    @Autowired
    InstructorRepository profileRepository;

    @Autowired
    InstructorService instructorService;

    @Autowired
    ProfileService profileService;

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorController instructorController;

    MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(instructorController).build();
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
        Instructor instructor8=new Instructor("joe","johnson",1);
        Instructor instructor9=new Instructor("pablo","scofield",8);

        profileRepository.save(instructor1);
        profileRepository.save(instructor2);
        profileRepository.save(instructor3);
        profileRepository.save(instructor4);
        profileRepository.save(instructor5);
        profileRepository.save(instructor6);
        profileRepository.save(instructor7);
        profileRepository.save(instructor8);
        profileRepository.save(instructor9);
    }
    @Test
    void showMainPage() throws Exception {
        mockMvc.perform(get("/instructor/all"))
                .andExpect(jsonPath("$",hasSize(9)));
    }
}