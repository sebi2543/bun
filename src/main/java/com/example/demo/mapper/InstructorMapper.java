package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    BasicInstructorDTO toBasic(Instructor instructor);

    List<BasicInstructorDTO>toBasic(List<Instructor>instructor);

    Instructor toEntity(BasicInstructorDTO instructor);

    SortInstructorDTO toSort(Instructor instructor);

    List<SortInstructorDTO> toSort(List<Instructor> instructor);

}