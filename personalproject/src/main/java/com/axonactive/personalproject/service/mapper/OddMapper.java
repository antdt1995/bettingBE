package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OddMapper {
    OddMapper INSTANCE= Mappers.getMapper(OddMapper.class);

    @Mapping(source = "oddType.oddType", target = "oddType")
    @Mapping(source = "footballMatch.homeTeam.name", target = "homeTeamName")
    OddCustomDto toDto(Odd odd);

    List<OddCustomDto> toDtos(List<Odd>odds);
}
