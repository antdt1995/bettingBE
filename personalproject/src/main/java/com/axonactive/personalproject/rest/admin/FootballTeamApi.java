package com.axonactive.personalproject.rest.admin;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/bet/admin/footballteams")
public interface FootballTeamApi {

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteFootballTeamById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<FootballTeamDto> createFootballTeam(@RequestBody FootballTeamDto footballTeamDto);

    @PutMapping("/{id}")
    ResponseEntity<FootballTeamDto> updateFootballTeam(@RequestBody FootballTeamDto footballTeamDto, @PathVariable("id") Long id);
}
