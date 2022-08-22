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
    BasicCourseDTO toBasic(Course course);

    @Mapping(target = "title",source = "title")
    List<BasicCourseDTO> toBasics(List<Course> courses);

    @Mapping(target = "id",source = "id")
    Course toEntity(IdentificationCourseDTO course);

    @Mapping(target = "title",source = "title")
    Course toEntity(BasicCourseDTO basicCourseDTO);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    SortCourseDTO toSort(Course course);

    @Mapping(target = "title",source = "title")
    @Mapping(target = "rating",source = "rating")
    List<SortCourseDTO>toSort(List<Course> courses);

}
