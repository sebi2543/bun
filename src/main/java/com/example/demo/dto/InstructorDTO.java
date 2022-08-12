package com.example.demo.dto;

import lombok.Data;
@Data
public class InstructorDTO {

    private String firstName;
    private String lastName;

    public InstructorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
