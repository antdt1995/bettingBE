package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.RoleType;
import com.axonactive.personalproject.service.dto.RoleTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleTypeMapper {
    RoleTypeMapper INSTANCE= Mappers.getMapper(RoleTypeMapper.class);
    RoleTypeDto toDto(RoleType roleType);
    List<RoleTypeDto> toDtos(List<RoleType>roleTypes);
}
