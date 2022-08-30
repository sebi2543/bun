package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Table(name = "Profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String linkedin;

    @Column
    private String youtube;

    public Profile(String linkedin, String youtube) {
        this.linkedin = linkedin;
        this.youtube = youtube;
    }
}
