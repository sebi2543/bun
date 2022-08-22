package com.example.demo.mapper;

import com.example.demo.dto.*;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    BasicInstructorDTO instructorToDTO(Instructor instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    List<BasicInstructorDTO>instructorsToDTOS(List<Instructor>instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    Instructor instructorDTOtoInstructor(BasicInstructorDTO instructor);

    @Mapping(source ="id",target = "id")
    Instructor instructorDTOIdTOInstructor(IdentificationInstructorDTO instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
    SortInstructorDTO instructorToInstructorDTORating(Instructor instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
    List<SortInstructorDTO> instructorsToInstructorDTOSRating(List<Instructor> instructor);

    @Mapping(source ="firstName",target = "firstName")
    FirstNameExceptionInstructorDTO instructorToInstructorDTOFirstName(Instructor instructor);

    @Mapping(source ="firstName",target = "firstName")
    List<FirstNameExceptionInstructorDTO> instructorsToInstructorDTOFirstNames(List<Instructor> instructor);

    @Mapping(source ="lastName",target = "lastName")
    LastNameExceptionInstructorDTO instructorToInstructorDTOLastName(Instructor instructor);

    @Mapping(source ="lastName",target = "lastName")
   List<LastNameExceptionInstructorDTO>instructorsToInstructorDTOLastNames(List<Instructor> instructor);
}