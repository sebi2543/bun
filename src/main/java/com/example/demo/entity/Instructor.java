package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private InstructorProfile instructorProfile;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Course> courses=new ArrayList<>();

    @Column
    private int rating;

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.instructorProfile = instructorProfile;
    }

    public Instructor(String firstName, String lastName, InstructorProfile instructorProfile) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
