package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "instructorProfiles")
@Getter
@Setter
@NoArgsConstructor
public class InstructorProfile {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String linkedin;

    @Column
    private String youtube;

    @OneToOne(mappedBy = "instructorProfile")
    private  Instructor instructor;

    public InstructorProfile(String linkedin, String youtube) {
        this.linkedin = linkedin;
        this.youtube = youtube;
    }

    @Override
    public String toString() {
        return "InstructorProfile{" +
                "id=" + id +
                ", linkedin='" + linkedin + '\'' +
                ", youtube='" + youtube + '\'' +
                ", instructor=" + instructor.getFirstName() +instructor.getLastName()+
                '}';
    }
}
