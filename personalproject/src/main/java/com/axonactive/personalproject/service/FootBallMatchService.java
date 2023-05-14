package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;

import java.util.List;

public interface FootBallMatchService {
    List<FootballMatchCustomDto> findAllFootballMatch();
    FootballMatchCustomDto findFootballMatchById(Long id);
    void deleteFootballMatchById(Long id);
    FootballMatchCustomDto createFootballMatch(FootballMatchDto footballMatchDto, Long teamId);
    FootballMatchCustomDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id);
}
