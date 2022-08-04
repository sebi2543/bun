package com.example.demo.entity;

import com.example.demo.service.InstructorRepositoryService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

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

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn()
    private Instructor instructor;

    @Column
    private  int rating;

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
    }
}
