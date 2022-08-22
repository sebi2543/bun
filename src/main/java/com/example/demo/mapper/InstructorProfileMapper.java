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
    BasicInstructorProfileDTO toBasic(InstructorProfile instructorProfile);


    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    List<BasicInstructorProfileDTO> toBasic(List<InstructorProfile> instructorProfile);

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    InstructorProfile toEntity(BasicInstructorProfileDTO basicInstructorProfileDTO);

}
