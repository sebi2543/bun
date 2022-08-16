package com.example.demo.mapper;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDTO InstructorToDTO(Instructor instructor);
}
