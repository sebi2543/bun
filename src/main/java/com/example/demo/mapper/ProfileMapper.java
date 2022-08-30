package com.example.demo.mapper;

import com.example.demo.dto.BasicProfileDTO;
import com.example.demo.entity.Profile;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface ProfileMapper {

    BasicProfileDTO toBasic(Profile profile);

    List<BasicProfileDTO> toBasic(List<Profile> profile);

    @Mapping(target = "id", ignore = true)
    Profile toEntity(BasicProfileDTO basicProfileDTO);

}
