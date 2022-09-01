package com.example.demo.service;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
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
        Assertions.assertEquals(5,profileService.getAll().size());
        Assertions.assertFalse(profileService.findById(1).isPresent());
        Assertions.assertFalse(profileService.findById(7).isPresent());
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
        Assertions.assertEquals("newLinkedIn",profileService.findById(8).get().getLinkedin());
        Assertions.assertEquals("newYoutube",profileService.findById(8).get().getYoutube());

        Assertions.assertEquals("newLinkedIn1",profileService.findById(9).get().getLinkedin());
        Assertions.assertEquals("newYoutube1",profileService.findById(9).get().getYoutube());

    }
}