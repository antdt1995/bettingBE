package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OddMapper {
    OddMapper INSTANCE= Mappers.getMapper(OddMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "oddType.name", target = "oddType")
    @Mapping(source = "footballMatch.homeTeam.name", target = "homeTeamName")
    OddCustomDto toDto(Odd odd);

    List<OddCustomDto> toDtos(List<Odd>odds);
}
