package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "title",source = "title")
    @Mapping(target = "id",source = "id")
    CourseDTO courseToDTO(Course course);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "id",source = "id")
    List<CourseDTO>coursesToDTOS(List<Course> courses);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "id",source = "id")
    Course DTOToCourse(CourseDTO course);
}
