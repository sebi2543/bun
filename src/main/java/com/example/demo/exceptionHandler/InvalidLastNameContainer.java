package com.example.demo.exceptionHandler;


import com.example.demo.dto.LastNameExceptionInstructorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidLastNameContainer {

    private String message;
    private List<LastNameExceptionInstructorDTO> firstName;
}
