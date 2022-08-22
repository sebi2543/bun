package com.example.demo.exceptionHandler;

import com.example.demo.exception.*;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.mapper.InstructorMapper;
import com.example.demo.service.CourseService;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class InvalidHandler {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    InstructorService instructorService;

    @Autowired
    InstructorMapper instructorMapper;

    @ExceptionHandler(InvalidTitle.class)
    public HttpEntity<InvalidTitleContainer>invalidTitle(){
        return new HttpEntity<>(new InvalidTitleContainer(
                "Title cannot be null,these are some valid titles",
                courseMapper.toBasics(courseService.getAll()))
        );
    }

    @ExceptionHandler(InvalidFirstName.class)
    public HttpEntity<InvalidFirstNameContainer>invalidFirstName(){
        return new HttpEntity<>(
                new InvalidFirstNameContainer("firstName cannot be null",
                instructorMapper.toFirstNameException(instructorService.getAll())));
    }
    @ExceptionHandler(InvalidLastName.class)
    public HttpEntity<InvalidLastNameContainer>invalidLastName(){
        return new HttpEntity<>(
                new InvalidLastNameContainer("LastName cannot be null",
                       instructorMapper.toLastNameException(instructorService.getAll())));
    }

    @ExceptionHandler(InvalidIdCourse.class)
    public HttpEntity<String>invalidIdCourse(){
        return new HttpEntity<>("Invalid id course");
    }

    @ExceptionHandler(InvalidIdInstructor.class)
    public HttpEntity<String>invalidIdInstructor(){
        return new HttpEntity<>("Invalid id instructor");
    }

    @ExceptionHandler(InvalidInstructorProfileId.class)
    public HttpEntity<String>invalidInstructorProfileId(){
        return new HttpEntity<>("Invalid instructor profile id ");
    }

    @ExceptionHandler(InvalidLikedIn.class)
    public HttpEntity<String>invalidLinkedIn(){
        return new HttpEntity<>("invalid likedIn");
    }

    @ExceptionHandler(InvalidYoutube.class)
    public HttpEntity<String>invalidYoutube(){
        return new HttpEntity<>("invalid youtube");
    }

}
