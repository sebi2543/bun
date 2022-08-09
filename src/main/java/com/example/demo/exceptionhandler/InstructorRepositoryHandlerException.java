package com.example.demo.exceptionhandler;

import com.example.demo.exceptions.InvalidTitle;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class InstructorRepositoryHandlerException {

    @ExceptionHandler({InvalidDataAccessApiUsageException.class,IllegalArgumentException.class})
    public String addCourseException(){
        return "instructor must be in data base before it has a course";
    }

    @ExceptionHandler({InvalidTitle.class})
    public String searchCourseException(){
        return "Invalid title please consider:Title cannot be null and must have more than 3 letters";

    }
}
