package com.example.demo.mapper;

import com.example.demo.dto.BasicCourseDTO;
import com.example.demo.dto.FrontendCourseDTO;
import com.example.demo.dto.SortCourseDTO;
import com.example.demo.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    BasicCourseDTO toBasic(Course course);

    FrontendCourseDTO toFrontend(Course course);

    List<FrontendCourseDTO> toFrontends(List<Course> courses);

    List<BasicCourseDTO> toBasics(List<Course> courses);

    Course toEntity(BasicCourseDTO basicCourseDTO);

    SortCourseDTO toSort(Course course);

    List<SortCourseDTO>toSort(List<Course> courses);

}
