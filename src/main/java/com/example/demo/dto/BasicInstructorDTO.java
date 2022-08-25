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

    @NotEmpty(message = "cannot be null")
    @NotNull(message = "cannot be null")
    public  String firstName;
    @NotEmpty(message = "cannot be null")
    @NotNull(message = "cannot be null")
    public  String lastName;
}
