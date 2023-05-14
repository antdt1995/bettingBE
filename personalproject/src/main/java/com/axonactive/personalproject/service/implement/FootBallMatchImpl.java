package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.entity.FootballTeam;
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

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FootBallMatchImpl implements FootBallMatchService {
    private final FootballMatchRepository footballMatchRepository;
    private final FootBallTeamService footBallTeamService;
    @Override
    public List<FootballMatchCustomDto> findAllFootballMatch() {
        List<FootballMatch> footballMatch=footballMatchRepository.findAll();
        if(footballMatch.isEmpty()){
            throw ProjectException.footballMatchNotFound();
        }
        return FootballMatchMapper.INSTANCE.toDtos(footballMatch);
    }

    @Override
    public FootballMatchCustomDto findFootballMatchById(Long id) {
        FootballMatch footballMatch=footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }

    @Override
    public void deleteFootballMatchById(Long id) {
        FootballMatch footballMatch=footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        footballMatchRepository.delete(footballMatch);
    }

    @Override
    public FootballMatchCustomDto createFootballMatch(FootballMatchDto footballMatchDto, Long teamId) {
        FootballTeamDto footballTeamDto=footBallTeamService.getFootballTeamById(teamId);
        FootballTeam footballTeam= FootballTeamMapper.INSTANCE.toEntity(footballTeamDto);
        if(footballMatchDto.getAwayScore()<0||footballMatchDto.getHomeScore()<0 || footballMatchDto.getTotalScore()<0){
            throw ProjectException.badRequest("EnterScoreError","Enter score cannot be negative");
        }
        FootballMatch footballMatch=FootballMatch.builder()
                .homeScore(footballMatchDto.getHomeScore())
                .awayScore(footballMatchDto.getAwayScore())
                .totalScore(footballMatchDto.getTotalScore())
                .startDate(footballMatchDto.getStartDate())
                .homeTeam(footballTeam)
                .awayTeam(footballTeam)
        .build();
        footballMatch= footballMatchRepository.save(footballMatch);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }

    @Override
    public FootballMatchCustomDto updateFootballMatch(FootballMatchDto footballMatchDto, Long id) {
        FootballMatch footballMatch=footballMatchRepository.findById(id).orElseThrow(ProjectException::footballMatchNotFound);
        footballMatch.setAwayScore(footballMatchDto.getAwayScore());
        footballMatch.setHomeScore(footballMatchDto.getHomeScore());
        footballMatch.setStartDate(footballMatchDto.getStartDate());
        footballMatch.setTotalScore(footballMatchDto.getTotalScore());
        footballMatch=footballMatchRepository.save(footballMatch);
        return FootballMatchMapper.INSTANCE.toDto(footballMatch);
    }
}
