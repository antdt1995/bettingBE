package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.OddType;
import com.axonactive.personalproject.service.dto.OddTypeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OddTypeMapper {
    OddTypeMapper INSTANCE= Mappers.getMapper(OddTypeMapper.class);
    OddTypeDto toDto(OddType oddType);
    List<OddTypeDto> toDtos(List<OddType>oddTypes);
}
