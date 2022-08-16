package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "title",target = "title")
    CourseDTO courseToDTO(Course course);
}
