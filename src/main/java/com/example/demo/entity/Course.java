package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column
    private String title;

    @ManyToOne()
    @JoinColumn()
    private Instructor instructor;

    @Column
    private  int rating;

    public Course(String title) {
        this.title = title;
    }
}
