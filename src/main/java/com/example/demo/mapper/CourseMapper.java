package com.example.demo.mapper;

import com.example.demo.dto.BasicCourseDTO;
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
    Course toEntity(BasicCourseDTO basicCourseDTO);

    @Mapping(target = "title", ignore = true)
    SortCourseDTO toSort(Course course);

    List<SortCourseDTO>toSort(List<Course> courses);

}
