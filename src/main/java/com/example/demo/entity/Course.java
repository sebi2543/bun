package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@NoArgsConstructor
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

    public String showInfo(){
        return this.title+" "+this.rating;
    }
}
