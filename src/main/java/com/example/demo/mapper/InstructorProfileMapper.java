package com.example.demo.mapper;

import com.example.demo.dto.InstructorProfileDTO;
import com.example.demo.entity.InstructorProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorProfileMapper {

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    InstructorProfileDTO instructorProfileToDTO(InstructorProfile instructorProfile);


    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    List<InstructorProfileDTO> instructorsProfileToDTOS(List<InstructorProfile> instructorProfile);

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    InstructorProfile instructorDTOToInstructor(InstructorProfileDTO instructorProfileDTO);

}
