package com.example.demo.exceptionhandler;

import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class InstructorRepositoryHandlerException {

    @ExceptionHandler({InvalidDataAccessApiUsageException.class,IllegalArgumentException.class})
    public String addCourseError(){
        return new String("instructor must be in data base before it has a course");
    }

}
