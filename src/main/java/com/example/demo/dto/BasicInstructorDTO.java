package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicInstructorDTO {

    @NotEmpty
    @NotNull
    public  String firstName;
    @NotEmpty
    @NotNull
    public  String lastName;
}
