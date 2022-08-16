package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "instructorProfiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InstructorProfile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String linkedin;

    @Column
    private String youtube;
}
