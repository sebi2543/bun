package com.example.demo.mapper;

import com.example.demo.dto.BasicInstructorProfileDTO;
import com.example.demo.entity.InstructorProfile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InstructorProfileMapper {

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    BasicInstructorProfileDTO instructorProfileToDTO(InstructorProfile instructorProfile);


    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    List<BasicInstructorProfileDTO> instructorsProfileToDTOS(List<InstructorProfile> instructorProfile);

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    InstructorProfile instructorDTOToInstructor(BasicInstructorProfileDTO basicInstructorProfileDTO);

}
