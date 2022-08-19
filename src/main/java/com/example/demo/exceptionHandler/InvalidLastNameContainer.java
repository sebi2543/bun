package com.example.demo.exceptionHandler;


import com.example.demo.dto.InstructorDTOLastName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidLastNameContainer {

    private String message;
    private List<InstructorDTOLastName> firstName;
}
