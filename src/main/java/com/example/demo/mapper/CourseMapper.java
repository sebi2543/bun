package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
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

    @Mapping(target = "title",source = "title")
    Course DTOToCourse(CourseDTO course);
}
