package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootBallMatchImpl implements FootBallMatchService {
    private final FootballMatchRepository footballMatchRepository;
    private final FootBallTeamService footBallTeamService;
    @Override
    public List<FootballMatchCustomDto> findAllFootballMatch() {
        try{
        List<FootballMatch> footballMatch=footballMatchRepository.findAll();
        if(footballMatch.isEmpty()){
            throw ProjectException.footballMatchNotFound();
        }
        return FootballMatchMapper.INSTANCE.toDtos(footballMatch);
        }catch (ResponseException e){
            throw new ResponseException("ErrorOccur","Error has been occur, Please comeback later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FootballMatchCustomDto findFootballMatchById(Long id) {
        try{
        FootballMatch footballMatch=footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
        }catch (ResponseException e){
            throw new ResponseException("ErrorOccur","Error has been occur, Please comeback later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public void deleteFootballMatchById(Long id) {
        try{
        FootballMatch footballMatch=footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        footballMatchRepository.delete(footballMatch);
        }catch (ResponseException e){
            throw new ResponseException("ErrorOccur","Error has been occur, Please comeback later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FootballMatchDto createFootballMatch(FootballMatchDto footballMatchDto, Long homeTeamId,Long awayTeamId) {
        try{
        //get home team
        FootballTeamDto footballTeamDto=footBallTeamService.getFootballTeamById(homeTeamId);
        FootballTeam homeTeam= FootballTeamMapper.INSTANCE.toEntity(footballTeamDto);
        //get away team
        FootballTeamDto footballTeamDto1=footBallTeamService.getFootballTeamById(awayTeamId);
        FootballTeam awayTeam=FootballTeamMapper.INSTANCE.toEntity(footballTeamDto1);
        if(footballMatchDto.getAwayScore()<0||footballMatchDto.getHomeScore()<0 || footballMatchDto.getTotalScore()<0){
            throw ProjectException.badRequest("EnterScoreError","Enter score cannot be negative");
        }
        if(footballMatchDto.getStartDate().compareTo(LocalDate.now())>7){
            throw ProjectException.badRequest("StartDateTooFar","Start date too far from now");
        }
        FootballMatch footballMatch=FootballMatch.builder()
                .homeScore(footballMatchDto.getHomeScore())
                .awayScore(footballMatchDto.getAwayScore())
                .totalScore(footballMatchDto.getTotalScore())
                .startDate(footballMatchDto.getStartDate())
                .homeTeam(homeTeam)
                .awayTeam(awayTeam)
        .build();
        footballMatch= footballMatchRepository.save(footballMatch);
        return FootballMatchMapper.INSTANCE.toXDto(footballMatch);
        }catch (ResponseException e){
            throw new ResponseException("ErrorOccur","Error has been occur, Please comeback later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public FootballMatchDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id) {
        try {
            FootballMatch footballMatch = footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
            footballMatch.setAwayScore(footballMatchDto.getAwayScore());
            footballMatch.setHomeScore(footballMatchDto.getHomeScore());
            footballMatch.setStartDate(footballMatchDto.getStartDate());
            footballMatch.setTotalScore(footballMatchDto.getTotalScore());
            footballMatch = footballMatchRepository.save(footballMatch);
            return FootballMatchMapper.INSTANCE.toXDto(footballMatch);
        }catch (ResponseException e){
            throw new ResponseException("ErrorOccur","Error has been occur, Please comeback later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
