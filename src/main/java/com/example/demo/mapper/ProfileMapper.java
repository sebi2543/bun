package com.example.demo.mapper;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    BasicProfileDTO toBasic(Profile profile);


    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    List<BasicProfileDTO> toBasic(List<Profile> profile);

    @Mapping(source = "linkedin",target ="linkedin")
    @Mapping(source = "youtube",target ="youtube")
    Profile toEntity(BasicProfileDTO basicProfileDTO);

}
