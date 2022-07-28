package com.example.demo.entity;

import com.example.demo.service.CourseService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "instructor_id")
    public  Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne
    @JoinColumn
    private InstructorProfile instructorProfile;

    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    private List<Course> courses=new ArrayList<>();



    public Instructor(String firstName, String lastName, InstructorProfile instructorProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorProfile = instructorProfile;
    }

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
