package com.example.demo.mapper;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    InstructorMapper INSTANCE = Mappers.getMapper(InstructorMapper.class);
    @Mapping(target = "firstName")
    @Mapping(target = "lastName")
    InstructorDTO InstructorToDTO(Instructor instructor);
}
