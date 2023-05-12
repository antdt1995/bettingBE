package com.axonactive.personalproject.api;

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
@RequestMapping("/project/footballteams")
@Slf4j
public class FootballTeamResources {
    private final FootBallTeamService footBallTeamService;
    @GetMapping
    public ResponseEntity<List<FootballTeamDto>> getAllFootballTeam(){
        log.info("Get all football team");
        return ResponseEntity.ok(footBallTeamService.getAllFootballTeam());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FootballTeamDto> getFootballTeamById(@PathVariable("id") Long id){
        log.info("Get football team by id {}",id);
        return ResponseEntity.ok(footBallTeamService.getFootballTeamById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballTeamById(@PathVariable("id") Long id){
        log.info("delete football team by id{}", id);
        String message = "Football team with ID " + id + " has been successfully deleted.";
        footBallTeamService.deleteFootballTeam(id);
        return ResponseEntity.noContent().header("Success",message).build();
    }
    @PostMapping
    public ResponseEntity<FootballTeamDto> createFootballTeam(@RequestBody FootballTeamDto footballTeamDto){
        log.info("create football team");
        FootballTeamDto footballTeamDto1=footBallTeamService.createFootballTeam(footballTeamDto);
        return ResponseEntity.created(URI.create("/project/footballteams/"+footballTeamDto1.getId())).body(footballTeamDto1);
    }
    @PutMapping("/{id}")
    public ResponseEntity<FootballTeamDto> updateFootballTeam(@RequestBody FootballTeamDto footballTeamDto, @PathVariable("id") Long id){
        log.info("update football team by id{}",id);
        FootballTeamDto footballTeamDto1=footBallTeamService.updateFootballTeam(footballTeamDto,id);
        return ResponseEntity.ok().body(footballTeamDto1);
    }
}
