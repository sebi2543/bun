package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructorProfiles")
public class InstructorProfile {
    @Id
    @Column(name = "instructor_profile_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "instructor_profile_linkedin")
    private String linkedin;

    @Column(name = "instructor_profile_youtube")
    private String youtube;

    @OneToOne(mappedBy = "instructorProfile")
    private  Instructor instructor;

    public Instructor getInstructor() {
        return instructor;
    }


    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorProfile() {
    }

    public InstructorProfile(String linkedin, String youtube) {
        this.linkedin = linkedin;
        this.youtube = youtube;
    }

    @Override
    public String toString() {
        return "InstructorProfile{" +
                "id=" + id +
                ", linkedin='" + linkedin + '\'' +
                ", youtube='" + youtube + '\'' +
                ", instructor=" + instructor.getFirstName()+" "+instructor.getLastName() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getYoutube() {
        return youtube;
    }

    public void setYoutube(String youtube) {
        this.youtube = youtube;
    }
}
