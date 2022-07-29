package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor


public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    public Long getId() {
        return id;
    }

    @ManyToOne()
    @JoinColumn()
    private Instructor instructor;
    @Column
    private  int rating;


    public Course(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public Course(String title, Instructor instructor, int rating) {
        this.title = title;
        this.instructor = instructor;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor.getLastName() +instructor.getFirstName()+
                ", rating=" + rating +
                '}';
    }
}
