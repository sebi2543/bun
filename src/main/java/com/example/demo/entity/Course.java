package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
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

    @ManyToOne
    @JoinColumn
    private Instructor instructor;
    @Column
    private  int rating;


    public Course(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }
}
