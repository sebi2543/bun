package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
