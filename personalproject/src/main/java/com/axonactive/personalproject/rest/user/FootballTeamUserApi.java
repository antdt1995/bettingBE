package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.dto.FootballTeamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/bet/user/footballteams")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")

public interface FootballTeamUserApi {
    @GetMapping
    ResponseEntity<List<FootballTeamDto>> getAllFootballTeam();

    @GetMapping("/{id}")
    ResponseEntity<FootballTeamDto> getFootballTeamById(@PathVariable("id") Long id);

}
