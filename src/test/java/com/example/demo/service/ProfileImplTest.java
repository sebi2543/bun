package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
import org.checkerframework.checker.nullness.Opt;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
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
import java.security.InvalidParameterException;
import java.util.Optional;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public
class ProfileImplTest {

    @Autowired
    ProfileService profileService;

    @BeforeEach
    public void populateDB(){
        Profile profile1=new Profile("johnLinkedIn","smithYoutube");
        Profile profile2=new Profile("davidLinkedIn","davidYoutube");
        Profile profile3=new Profile("crisLinkedIn","crisYoutube");
        Profile profile4=new Profile("keanLinkedIn","leanYoutube");
        Profile profile5=new Profile("tobyLinkedIn","tobyYoutube");
        Profile profile6=new Profile("saraLinkedIn","saraYoutube");
        Profile profile7=new Profile("lincLinkedIn","lincYoutube");

        profileService.save(profile1);
        profileService.save(profile2);
        profileService.save(profile3);
        profileService.save(profile4);
        profileService.save(profile5);
        profileService.save(profile6);
        profileService.save(profile7);
    }

    @Test
    void delete_MultipleProfiles_ProfilesAreDeleted() {
        profileService.delete(1);
        profileService.delete(7);
        Assertions.assertThrows(InvalidParameterException.class,()->{
            profileService.getById(1);
        });

        Assertions.assertThrows(InvalidParameterException.class,()->{
            profileService.getById(1);
        });
        Assertions.assertThrows(InvalidParameterException.class,()->{
            profileService.getById(1);
        });
    }

    @Test
    void update_MultipleProfiles_ProfilesAreUpdated() {
        profileService.update(3,new BasicProfileDTO("LINKEDIN","YOUTUBE"));
        profileService.update(7,new BasicProfileDTO("LINKEDIN1","YOUTUBE1"));
        Assertions.assertEquals("LINKEDIN",profileService.getById(3).getLinkedin());
        Assertions.assertEquals("YOUTUBE",profileService.getById(3).getYoutube());

        Assertions.assertEquals("LINKEDIN1",profileService.getById(7).getLinkedin());
        Assertions.assertEquals("YOUTUBE1",profileService.getById(7).getYoutube());

    }
    @Test
    void add_MultipleProfiles_ProfilesAreAdded() {
        profileService.add(new BasicProfileDTO("newLinkedIn","newYoutube"));
        profileService.add(new BasicProfileDTO("newLinkedIn1","newYoutube1"));
        Assertions.assertEquals(9,profileService.getAll().size());
        Assertions.assertAll(
        ()->Assertions.assertEquals("newLinkedIn",profileService.getById((8)).getLinkedin()),
        ()->Assertions.assertEquals("newYoutube",profileService.getById(8).getYoutube()),
        ()->Assertions.assertEquals("newLinkedIn1",profileService.getById(9).getLinkedin()),
        ()->Assertions.assertEquals("newYoutube1",profileService.getById(9).getYoutube())
        );
    }
}