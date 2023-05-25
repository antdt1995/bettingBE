package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FootBallMatchService {
    List<FootballMatchCustomDto> findAllFootballMatch();
    FootballMatchCustomDto findFootballMatchById(Long id);
    void deleteFootballMatchById(Long id);
    FootballMatchDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeId,Long awayId);
    FootballMatchDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id);
    List<Long> findInvoiceByMatchId(@Param("matchId") Long matchId);
    List<Long> findHouseByMatchId(@Param("matchId") Long matchId);

}
