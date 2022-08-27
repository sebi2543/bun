package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor

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
    private Profile profile;

    @OneToMany(mappedBy = "instructor")
    private List<Course>courses = new ArrayList<>();

    @Column
    private int rating;

    public Instructor(int rating) {
        this.rating = rating;
    }

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course){
        this.courses.add(course);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instructorProfile=" + profile +
                ", courses=" + courses +
                ", rating=" + rating +
                '}';
    }
}

