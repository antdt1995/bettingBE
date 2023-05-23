package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.FootballTeam;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.repository.FootballTeamRepository;
import com.axonactive.personalproject.service.FootBallTeamService;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import com.axonactive.personalproject.service.mapper.FootballTeamMapper;
import lombok.RequiredArgsConstructor;

import static com.axonactive.personalproject.exception.BooleanMethod.isAlpha;
import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumeric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballTeamImpl implements FootBallTeamService {
    private final FootballTeamRepository footballTeamRepository;

    @Override
    public List<FootballTeamDto> getAllFootballTeam() {
        return FootballTeamMapper.INSTANCE.toDtos(footballTeamRepository.findAll());
    }

    @Override
    public FootballTeamDto getFootballTeamById(Long id) {
        FootballTeam footballTeam = footballTeamRepository.findById(id).orElseThrow(ProjectException::footballTeamNotFound);
        return FootballTeamMapper.INSTANCE.toDto(footballTeam);
    }

    @Override
    public FootballTeamDto createFootballTeam(FootballTeamDto footballTeamDto) {
        exception(footballTeamDto);
        FootballTeam footballTeam = FootballTeam.builder()
                    .name(footballTeamDto.getName())
                    .league(footballTeamDto.getLeague())
                    .manager(footballTeamDto.getManager())
                    .build();
            footballTeam = footballTeamRepository.save(footballTeam);
            return FootballTeamMapper.INSTANCE.toDto(footballTeam);

    }

    @Override
    public FootballTeamDto updateFootballTeam(FootballTeamDto footballTeamDto, Long id) {
        FootballTeam footballTeam = footballTeamRepository.findById(id).orElseThrow(ProjectException::footballTeamNotFound);
        exception(footballTeamDto);
        footballTeam.setName(footballTeamDto.getName());
            footballTeam.setLeague(footballTeamDto.getLeague());
            footballTeam.setManager(footballTeamDto.getManager());
            footballTeam = footballTeamRepository.save(footballTeam);
            return FootballTeamMapper.INSTANCE.toDto(footballTeam);
    }

    @Override
    public void deleteFootballTeam(Long id) {
        FootballTeam footballTeam = footballTeamRepository.findById(id).orElseThrow(ProjectException::footballTeamNotFound);
            footballTeamRepository.delete(footballTeam);
    }

    private static void exception(FootballTeamDto footballTeamDto) {
        if (!isAlpha(footballTeamDto.getManager())) {
            throw ProjectException.badRequest("ManagerFormatError", "Manager format should contain only letters");
        }
        if (!isAlphanumeric(footballTeamDto.getLeague())) {
            throw ProjectException.badRequest("LeagueFormatError", "League format should contain only letters or numbers");
        }
    }
}
