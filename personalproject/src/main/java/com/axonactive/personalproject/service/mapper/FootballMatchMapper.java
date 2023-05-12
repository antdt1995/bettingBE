package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FootballMatchMapper {
    FootballMatchMapper INSTANCE = Mappers.getMapper(FootballMatchMapper.class);

    @Mapping(source = "homeTeam.name", target = "homeTeamName")
    @Mapping(source = "awayTeam.name", target = "awayTeamName")
    FootballMatchCustomDto toDto(FootballMatch footballMatch);
    List<FootballMatchCustomDto> toDtos(List<FootballMatch> footballMatches);
}
