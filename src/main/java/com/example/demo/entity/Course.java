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

    @ManyToOne( cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn
    private Instructor instructor;


    public Course(String title) {
        this.title = title;
    }
}
