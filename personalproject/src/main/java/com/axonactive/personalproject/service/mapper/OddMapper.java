package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.service.dto.OddDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Map;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OddMapper {
    OddMapper INSTANCE= Mappers.getMapper(OddMapper.class);

    @Mapping(source = "oddType.oddType", target = "oddType")
    @Mapping(source = "footballMatch.homeTeam.name", target = "homeTeamName")
    OddDto toDto(Odd odd);

    List<OddDto> toDtos(List<Odd>odds);
}
