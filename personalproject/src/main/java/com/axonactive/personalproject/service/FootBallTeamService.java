package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.dto.FootballTeamDto;

import java.util.List;

public interface FootBallTeamService {
    List<FootballTeamDto> getAllFootballTeam();
    FootballTeamDto getFootballTeamById(Long id);
    FootballTeamDto createFootballTeam(FootballTeamDto footballTeamDto);
    FootballTeamDto updateFootballTeam(FootballTeamDto footballTeamDto, Long id);
    void deleteFootballTeam(Long id);
}
