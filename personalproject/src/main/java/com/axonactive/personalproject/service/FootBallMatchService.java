package com.axonactive.personalproject.service;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.customDto.FootballMatchWithCountTotalBet;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FootBallMatchService {
    List<FootballMatchCustomDto> findAllFootballMatch();
    FootballMatchCustomDto findFootballMatchById(Long id);
    void deleteFootballMatchById(Long id);
    FootballMatchCustomDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeId,Long awayId);
    FootballMatchCustomDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id);
    List<Long> findInvoiceDetailByMatchId(@Param("matchId") Long matchId);
    List<Long> findHouseByMatchId(@Param("matchId") Long matchId);
    List<FootballMatchWithTotalBet> getAllMatchWithTotalBetBetweenDate(LocalDate fromDate, LocalDate endDate);
    List<FootballMatchWithTotalBet> getAllMatchByTotalBet(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate, Pageable pageable);
    List<FootballMatchWithCountTotalBet> getAllMatchByCountTotalBet(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate,Pageable pageable);

}
