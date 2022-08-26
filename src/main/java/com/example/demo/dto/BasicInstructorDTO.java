package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicInstructorDTO {

    @NotBlank
    @Size(min = 3,max = 15)
    public  String firstName;

    @NotBlank
    @Size(min = 3,max = 15)
    public  String lastName;
}
