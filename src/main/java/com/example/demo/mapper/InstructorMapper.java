package com.example.demo.mapper;

import com.example.demo.dto.InstructorDTO;
import com.example.demo.entity.Instructor;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorMapper {

    InstructorDTO instructorToDTO(Instructor instructor);
    List<InstructorDTO>instructorsToDTOS(List<Instructor>instructor);
    Instructor instructorDTOtoInstructor(InstructorDTO instructorDTO);
}
