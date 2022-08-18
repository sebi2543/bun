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
    private InstructorProfile instructorProfile;

    @OneToMany(mappedBy = "instructor")
    private List<Course>courses = new ArrayList<>();

    @Column
    private int rating;

    public Instructor(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addCourse(Course course){
        List<Course>old =courses;
        this.courses=new ArrayList<>(old);
        courses.add(course);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", instructorProfile=" + instructorProfile +
                ", courses=" + courses +
                ", rating=" + rating +
                '}';
    }
}

