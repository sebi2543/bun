package com.example.demo.mapper;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.IdentificationCourseDTO;
import com.example.demo.dto.SortCourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    @Mapping(target = "title",source = "title")
    BasicCourseDTO courseToDTO(Course course);

    @Mapping(target = "title",source = "title")
    List<BasicCourseDTO>coursesToDTOS(List<Course> courses);

    @Mapping(target = "id",source = "id")
    Course courseDTOIdTOCourse(IdentificationCourseDTO course);

    @Mapping(target = "title",source = "title")
    Course courseDTOToCourse(BasicCourseDTO basicCourseDTO);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    SortCourseDTO courseToCourseDTORating(Course course);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    List<SortCourseDTO> coursesToCourseDTOSRating(List<Course> courses);

}
