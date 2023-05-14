package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FootballTeamMapper {
    FootballTeamMapper INSTANCE= Mappers.getMapper(FootballTeamMapper.class);
    FootballTeamDto toDto(FootballTeam footballTeam);
    List<FootballTeamDto> toDtos(List<FootballTeam> footballTeams);
    FootballTeam toEntity(FootballTeamDto footballTeamDto);
    List<FootballTeam> toEntities(List<FootballTeamDto>footballTeamDtos);
}
