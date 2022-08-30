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
    private  float rating;

    @Column
    private int headcount;

    @Column
    private long sum;

    public Course(String title) {
        this.title = title;
    }

    public Course(String title, int rating) {
        this.title = title;
        this.rating = rating;
    }

    public Course(int rating) {
        this.rating = rating;
    }

    public void addGrade(long grade){
        headcount++;
        sum+=grade;
        rating= (float)sum/headcount;
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
