package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String linkedin;

    @Column
    private String youtube;
}
