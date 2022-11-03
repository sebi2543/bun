package com.example.demo.dto;

import com.example.demo.entity.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BasicCourseDTO {

    @NotBlank(message = "title can contain only letters")
    @Size(min = 2,max = 10,message = "title must be between 2 and 10 letters")
    private String title;
}

