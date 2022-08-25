package com.example.demo.exceptionHandler;

import com.example.demo.dto.BasicCourseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvalidTitleContainer {
    private String message;
    private List<BasicCourseDTO> basicCourseDTOS;

}
