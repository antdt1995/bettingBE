package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.service.FootBallTeamService;
import com.axonactive.personalproject.service.dto.FootballTeamDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.isAlpha;
import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumeric;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project/footballteams")
@Slf4j
public class FootballTeamResources {
    private final FootBallTeamService footBallTeamService;

    @GetMapping
    public ResponseEntity<List<FootballTeamDto>> getAllFootballTeam() {
        log.info("Get all football team");
        return ResponseEntity.ok(footBallTeamService.getAllFootballTeam());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballTeamDto> getFootballTeamById(@PathVariable("id") Long id) {
        log.info("Get football team by id {}", id);
        FootballTeamDto footballTeamDto = footBallTeamService.getFootballTeamById(id);
        try {
            return ResponseEntity.ok(footballTeamDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballTeamById(@PathVariable("id") Long id) {
        log.info("delete football team by id{}", id);
        String message = "Football team with ID " + id + " has been successfully deleted.";
        footBallTeamService.deleteFootballTeam(id);
        try {

            return ResponseEntity.noContent().header("Success", message).build();
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PostMapping
    public ResponseEntity<FootballTeamDto> createFootballTeam(@RequestBody FootballTeamDto footballTeamDto) {
        log.info("create football team");
        try {
            FootballTeamDto footballTeamDto1 = footBallTeamService.createFootballTeam(footballTeamDto);
            return ResponseEntity.created(URI.create("/project/footballteams/" + footballTeamDto1.getId())).body(footballTeamDto1);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FootballTeamDto> updateFootballTeam(@RequestBody FootballTeamDto footballTeamDto, @PathVariable("id") Long id) {
        log.info("update football team by id");
        FootballTeamDto footballTeamDto1 = footBallTeamService.updateFootballTeam(footballTeamDto, id);
        try {
            return ResponseEntity.ok().body(footballTeamDto1);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }
}
