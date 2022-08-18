package com.example.demo.entity;

import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String title;

    @ManyToOne
    @JoinColumn
    private Instructor instructor;

    @Column
    private  int rating;


    public Course(String title) {
        this.title = title;
    }


    public Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
