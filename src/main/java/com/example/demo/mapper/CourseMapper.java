package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
import com.example.demo.dto.CourseDTOId;
import com.example.demo.dto.CourseDTORating;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "title",source = "title")
    CourseDTO courseToDTO(Course course);

    @Mapping(target = "title",source = "title")
    List<CourseDTO>coursesToDTOS(List<Course> courses);

    @Mapping(target = "id",source = "id")
    Course courseDTOIdTOCourse(CourseDTOId course);

    @Mapping(target = "title",source = "title")
    Course courseDTOToCourse(CourseDTO courseDTO);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    CourseDTORating courseToCourseDTORating(Course course);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    List<CourseDTORating> coursesToCourseDTOSRating(List<Course> courses);

}
