package com.axonactive.personalproject.service;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.customDto.FootballMatchWithCountTotalBet;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import com.axonactive.personalproject.service.dto.HouseDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FootBallMatchService {
    List<FootballMatchCustomDto> findAllFootballMatch();
    FootballMatchCustomDto findFootballMatchById(Long id);
    void deleteFootballMatchById(Long id);
    FootballMatchCustomDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeId,Long awayId);
    FootballMatchCustomDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id);
    List<Long> findInvoiceDetailByMatchId(@Param("matchId") Long matchId);
    List<Long> findHouseByMatchId(@Param("matchId") Long matchId);
    List<FootballMatchWithTotalBet> getAllMatchWithTotalBetBetweenDate(LocalDateTime fromDate, LocalDateTime endDate);
    List<FootballMatchWithTotalBet> getAllMatchByTotalBet(@Param("fromDate") LocalDateTime fromDate, @Param("endDate") LocalDateTime endDate, Pageable pageable);
    List<FootballMatchWithCountTotalBet> getAllMatchByCountTotalBet(@Param("fromDate") LocalDateTime fromDate, @Param("endDate") LocalDateTime endDate,Pageable pageable);
    List<AccountDto> findAccountByMatchId(Long matchID);
    HouseDto findHouse();
}
