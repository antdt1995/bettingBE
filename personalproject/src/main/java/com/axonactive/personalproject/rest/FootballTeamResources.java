package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.FootballTeamApi;
import com.axonactive.personalproject.rest.user.FootballTeamUserApi;
import com.axonactive.personalproject.service.FootBallTeamService;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class FootballTeamResources implements FootballTeamApi, FootballTeamUserApi {
    private final FootBallTeamService footBallTeamService;

    @Override
    public ResponseEntity<List<FootballTeamDto>> getAllFootballTeam() {
        return ResponseEntity.ok(footBallTeamService.getAllFootballTeam());
    }

    @Override
    public ResponseEntity<FootballTeamDto> getFootballTeamById(Long id) {
        FootballTeamDto footballTeamDto = footBallTeamService.getFootballTeamById(id);
        return ResponseEntity.ok(footballTeamDto);
    }

    @Override
    public ResponseEntity<Void> deleteFootballTeamById(Long id) {
        log.debug("--> Request delete football team by id{}", id);
        String message = "Football team with ID " + id + " has been successfully deleted.";
        footBallTeamService.deleteFootballTeam(id);

        return ResponseEntity.noContent().header("Success", message).build();

    }

    @Override
    public ResponseEntity<FootballTeamDto> createFootballTeam(FootballTeamDto footballTeamDto) {
        log.debug("--> Request create football team");
        FootballTeamDto footballTeamDto1 = footBallTeamService.createFootballTeam(footballTeamDto);
        return ResponseEntity.created(URI.create("/bet/footballteams/" + footballTeamDto1.getId())).body(footballTeamDto1);
    }

    @Override
    public ResponseEntity<FootballTeamDto> updateFootballTeam(FootballTeamDto footballTeamDto, Long id) {
        log.debug("--> Request update football team by id");
        FootballTeamDto footballTeamDto1 = footBallTeamService.updateFootballTeam(footballTeamDto, id);
        return ResponseEntity.ok().body(footballTeamDto1);
    }
}
