package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.*;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.FootballMatchRepository;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.FootBallTeamService;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import com.axonactive.personalproject.service.mapper.FootballMatchMapper;
import com.axonactive.personalproject.service.mapper.FootballTeamMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootBallMatchImpl implements FootBallMatchService {
    private final FootballMatchRepository footballMatchRepository;
    private final FootBallTeamService footBallTeamService;
    private final HouseImpl house;

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
    public FootballMatchDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeTeamId, Long awayTeamId) {

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
                .build();
        footballMatch = footballMatchRepository.save(footballMatch);
        return FootballMatchMapper.INSTANCE.toXDto(footballMatch);
    }

    @Override
    public List<Long> findInvoiceByMatchId(Long matchId) {
        return footballMatchRepository.findInvoiceByMatchId(matchId);
    }

    @Override
    public List<Long> findHouseByMatchId(Long matchId) {
        return footballMatchRepository.findHouseByMatchId(matchId);
    }

    @Override
    public FootballMatchDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id) {
        exception(footballMatchDto);
        FootballMatch footballMatch = footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        footballMatch.setAwayScore(footballMatchDto.getAwayScore());
        footballMatch.setHomeScore(footballMatchDto.getHomeScore());
        footballMatch.setStartDate(footballMatchDto.getStartDate());
        footballMatch.setTotalScore(footballMatchDto.getTotalScore());
        footballMatch = footballMatchRepository.save(footballMatch);
        List<Long> invoiceIds=findInvoiceByMatchId(id);
        List<Long> houseIds=findHouseByMatchId(id);
        house.findOverUnderOdd(id);

        for (Long invoiceId : invoiceIds) {
            house.calcWin(invoiceId);
            for (Long houseId : houseIds) {
                house.getInterest(invoiceId, houseId);
            }
        }
        return FootballMatchMapper.INSTANCE.toXDto(footballMatch);

    }

}
