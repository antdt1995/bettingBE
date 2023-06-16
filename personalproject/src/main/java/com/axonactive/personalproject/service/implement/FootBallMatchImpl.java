package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.*;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.FootballMatchRepository;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.FootBallTeamService;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.customDto.FootballMatchWithCountTotalBet;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import com.axonactive.personalproject.service.mapper.FootballMatchMapper;
import com.axonactive.personalproject.service.mapper.FootballTeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootBallMatchImpl implements FootBallMatchService {
    private final FootballMatchRepository footballMatchRepository;
    private final FootBallTeamService footBallTeamService;
    private final HouseServiceImpl houseServiceImpl;

    private static void setFieldIntoFootballMatch(FootballMatchDto footballMatchDto, FootballMatch footballMatch) {
        footballMatch.setAwayScore(footballMatchDto.getAwayScore());
        footballMatch.setHomeScore(footballMatchDto.getHomeScore());
        footballMatch.setTotalScore(footballMatchDto.getTotalScore());
    }

    private static void exception(FootballMatchDto footballMatchDto) {
        if (footballMatchDto.getAwayScore() < 0 || footballMatchDto.getHomeScore() < 0 || footballMatchDto.getTotalScore() < 0) {
            throw ProjectException.badRequest("EnterScoreError", "Enter score cannot be negative");
        }
    }

    @Override
    public List<FootballMatchCustomDto> findAllFootballMatch() {

        List<FootballMatch> footballMatch = footballMatchRepository.findAll();
        if (footballMatch.isEmpty()) {
            throw ProjectException.footballMatchNotFound();
        }
        return FootballMatchMapper.INSTANCE.toDtos(footballMatch);
    }

    @Override
    public FootballMatchCustomDto findFootballMatchById(Long id) {
        FootballMatch footballMatch = footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }

    @Override
    public void deleteFootballMatchById(Long id) {
        FootballMatch footballMatch = footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        footballMatchRepository.delete(footballMatch);
    }

    @Override
    public FootballMatchCustomDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeTeamId, Long awayTeamId) {

        //get home team
        FootballTeamDto footballTeamDto = footBallTeamService.getFootballTeamById(homeTeamId);
        FootballTeam homeTeam = FootballTeamMapper.INSTANCE.toEntity(footballTeamDto);
        //get away team
        FootballTeamDto footballTeamDto1 = footBallTeamService.getFootballTeamById(awayTeamId);
        FootballTeam awayTeam = FootballTeamMapper.INSTANCE.toEntity(footballTeamDto1);
        FootballMatch footballMatch = FootballMatch.builder()
                .homeScore(footballMatchDto.getHomeScore())
                .awayScore(footballMatchDto.getAwayScore())
                .totalScore(footballMatchDto.getTotalScore())
                .startDate(footballMatchDto.getStartDate())
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
                .completeStatus(false)
                .build();
        footballMatch = footballMatchRepository.save(footballMatch);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }

    @Override
    public List<Long> findInvoiceDetailByMatchId(Long matchId) {
        return footballMatchRepository.findInvoiceDetailByMatchId(matchId);
    }

    @Override
    public List<Long> findHouseByMatchId(Long matchId) {
        return footballMatchRepository.findHouseByMatchId(matchId);
    }

    @Override
    public FootballMatchCustomDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id) {
        exception(footballMatchDto);
        FootballMatch footballMatch = footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        setFieldIntoFootballMatch(footballMatchDto, footballMatch);
        footballMatch = footballMatchRepository.save(footballMatch);

        footballMatch.setCompleteStatus(true);
        footballMatch = footballMatchRepository.save(footballMatch);

        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }

    @Override
    public List<FootballMatchWithTotalBet> getAllMatchWithTotalBetBetweenDate(LocalDate fromDate, LocalDate endDate) {
        return footballMatchRepository.getAllMatchWithTotalBetBetweenDate(fromDate, endDate);
    }

    @Override
    public List<FootballMatchWithCountTotalBet> getAllMatchByCountTotalBet(LocalDate fromDate, LocalDate endDate, Pageable pageable) {
        return footballMatchRepository.getAllMatchByCountTotalBet(fromDate, endDate, pageable);
    }

    @Override
    public List<FootballMatchWithTotalBet> getAllMatchByTotalBet(LocalDate fromDate, LocalDate endDate, Pageable pageable) {
        return footballMatchRepository.getAllMatchByTotalBet(fromDate, endDate, pageable);
    }
}
