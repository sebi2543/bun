package com.example.demo.entity;

import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instructor_id")
    public  Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_profile_id")
    private InstructorProfile instructorProfile;

    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.REMOVE},fetch = FetchType.EAGER)
    private List<Course> courses=new ArrayList<>();



    public Instructor() {
    }

    public Instructor(String firstName, String lastName, InstructorProfile instructorProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorProfile = instructorProfile;
    }

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public InstructorProfile getInstructorProfile() {
        return instructorProfile;
    }

    public void setInstructorProfile(InstructorProfile instructorProfile) {
        this.instructorProfile = instructorProfile;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instructorProfile=" + instructorProfile +
                ", courses=" + courses +
                '}';
    }
}
