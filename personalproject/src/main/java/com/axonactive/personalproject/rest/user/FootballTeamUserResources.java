package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.FootballTeamUserApi;
import com.axonactive.personalproject.service.FootBallTeamService;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
@Slf4j
public class FootballTeamUserResources implements FootballTeamUserApi {
    private final FootBallTeamService footBallTeamService;

    @Override
    public ResponseEntity<List<FootballTeamDto>> getAllFootballTeam() {
        return ResponseEntity.ok(footBallTeamService.getAllFootballTeam());
    }

    @Override
    public ResponseEntity<FootballTeamDto> getFootballTeamById(Long id) {
        return ResponseEntity.ok(footBallTeamService.getFootballTeamById(id));
    }
}
