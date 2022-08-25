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

    BasicCourseDTO toBasic(Course course);

    List<BasicCourseDTO> toBasics(List<Course> courses);

    @Mapping(target = "title", ignore = true)
    Course toEntity(IdentificationCourseDTO course);

    @Mapping(target = "title", ignore = true)
    Course toEntity(BasicCourseDTO basicCourseDTO);

    SortCourseDTO toSort(Course course);

    List<SortCourseDTO>toSort(List<Course> courses);

}
