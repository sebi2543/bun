package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "instructorProfiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

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
}
