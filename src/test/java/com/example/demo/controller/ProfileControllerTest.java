package com.example.demo.controller;

import com.example.demo.entity.Profile;
import com.example.demo.repository.ProfileRepository;
import com.example.demo.service.ProfileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.entity.Course;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class ProfileControllerTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileService profileService;

    @Autowired
    ProfileController profileController;

    ObjectMapper mapper;
    ObjectWriter ow;
    String requestJson;
    MockMvc mockMvc;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        mockMvc = MockMvcBuilders.standaloneSetup(profileController).build();
        mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ow = mapper.writer().withDefaultPrettyPrinter();
    }

    @BeforeEach
    public void populateDB(){
        Profile profile1=new Profile("johnLinkedIn","smithYoutube");
        Profile profile2=new Profile("davidLinkedIn","davidYoutube");
        Profile profile3=new Profile("crisLinkedIn","crisYoutube");
        Profile profile4=new Profile("keanLinkedIn","leanYoutube");
        Profile profile5=new Profile("tobyLinkedIn","tobyYoutube");
        Profile profile6=new Profile("saraLinkedIn","saraYoutube");
        Profile profile7=new Profile("lincLinkedIn","lincYoutube");

        profileRepository.save(profile1);
        profileRepository.save(profile2);
        profileRepository.save(profile3);
        profileRepository.save(profile4);
        profileRepository.save(profile5);
        profileRepository.save(profile6);
        profileRepository.save(profile7);
    }
    @Test
    void allProfile_NonEmpty_NotEmptyList() throws Exception {
        mockMvc.perform(get("/profile/all").contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$",hasSize(7)));
    }

    @Test
    void showIdProfile_ValidId_Success() throws Exception {
        mockMvc.perform(get("/profile/{id}",1).contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.linkedin",is("johnLinkedIn")))
                .andExpect(jsonPath("$.youtube",is("smithYoutube")));
    }
    @Test
    public void deleteProfile_ValidId_Deleted() throws Exception {
        mockMvc.perform(delete("/profile/{id}/delete",6).contentType(APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(profileService.getAll().size(),6);
    }

    @Test
    public void addProfile_ValidId_Added() throws Exception {
        requestJson = ow.writeValueAsString(new Profile("newLinkedIn","newYoutube"));
        mockMvc.perform(post("/profile/add").contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(profileService.getAll().size(),8);
    }
    @Test
    public void updateProfile_ValidId_Deleted() throws Exception {
        requestJson = ow.writeValueAsString(new Profile("newLinkedIn","newYoutube"));
        mockMvc.perform(put("/profile/{id}/update",3).contentType(APPLICATION_JSON_UTF8).content(requestJson))
                .andExpect(status().is2xxSuccessful());
        Assertions.assertEquals(profileService.getById(3).getLinkedin(),"newLinkedIn");
        Assertions.assertEquals(profileService.getById(3).getYoutube(),"newYoutube");
    }
}