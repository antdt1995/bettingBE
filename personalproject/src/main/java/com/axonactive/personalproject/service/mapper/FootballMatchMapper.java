package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface FootballMatchMapper {
    FootballMatchMapper INSTANCE = Mappers.getMapper(FootballMatchMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "homeTeam.name", target = "homeTeamName")
    @Mapping(source = "awayTeam.name", target = "awayTeamName")
    FootballMatchCustomDto toDto(FootballMatch footballMatch);
    List<FootballMatchCustomDto> toDtos(List<FootballMatch> footballMatches);

    FootballMatch toEntity(FootballMatchCustomDto footballMatchCustomDto);
    List<FootballMatch> toEntities(List<FootballMatchCustomDto> footballMatchCustomDtos);


    FootballMatchDto toXDto(FootballMatch footballMatch);
    List<FootballMatchDto> toXDtos(List<FootballMatch>footballMatches);
}
