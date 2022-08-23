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
    BasicInstructorDTO toBasic(Instructor instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    List<BasicInstructorDTO>toBasic(List<Instructor>instructor);

    @Mapping(source ="firstName",target = "firstName")
    @Mapping(source ="lastName",target = "lastName")
    Instructor toEntity(BasicInstructorDTO instructor);

    @Mapping(source ="id",target = "id")
    Instructor toEntity(IdentificationInstructorDTO instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
    SortInstructorDTO toSort(Instructor instructor);

    @Mapping(source ="id",target = "id")
    @Mapping(source = "rating",target = "rating")
    List<SortInstructorDTO> toSort(List<Instructor> instructor);

    @Mapping(source ="firstName",target = "firstName")
    FirstNameExceptionInstructorDTO toFirstNameException(Instructor instructor);

    @Mapping(source ="firstName",target = "firstName")
    List<FirstNameExceptionInstructorDTO> toFirstNameException(List<Instructor> instructor);

    @Mapping(source ="lastName",target = "lastName")
    LastNameExceptionInstructorDTO toLastNameException(Instructor instructor);

    @Mapping(source ="lastName",target = "lastName")
   List<LastNameExceptionInstructorDTO> toLastNameException(List<Instructor> instructor);
}