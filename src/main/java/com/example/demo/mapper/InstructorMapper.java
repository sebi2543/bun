package com.example.demo.mapper;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.dto.InstructorDTOId;
import com.example.demo.dto.InstructorDTORating;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    InstructorDTO instructorToDTO(Instructor instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    List<InstructorDTO>instructorsToDTOS(List<Instructor>instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    Instructor instructorDTOtoInstructor(InstructorDTO instructor);

    @Mapping(source ="id",target = "id")
    Instructor instructorDTOIdTOInstructor(InstructorDTOId instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
    InstructorDTORating instructorToInstructorDTORating(Instructor instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
   List<InstructorDTORating> instructorsToInstructorDTOSRating(List<Instructor> instructor);
}