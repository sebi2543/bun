package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseDTO {
    private String title;

    public CourseDTO(String title) {
        this.title = title;
    }
}
