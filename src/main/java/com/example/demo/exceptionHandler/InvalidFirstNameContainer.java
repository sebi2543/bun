package com.example.demo.exceptionHandler;

import com.example.demo.dto.InstructorDTOFirstName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class InvalidFirstNameContainer {
    private String message;
    private List<InstructorDTOFirstName>firstName;
}
