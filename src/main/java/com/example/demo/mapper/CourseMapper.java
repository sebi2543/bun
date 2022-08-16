package com.example.demo.mapper;

import com.example.demo.dto.CourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

//    CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);
    CourseDTO courseToDTO(Course course);
}
