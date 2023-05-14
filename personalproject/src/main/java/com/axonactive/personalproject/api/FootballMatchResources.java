package com.axonactive.personalproject.api;

import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/project/footballmatchs")
public class FootballMatchResources {
    private final FootBallMatchService footBallMatchService;
    @GetMapping
    public ResponseEntity<List<FootballMatchCustomDto>> getAllFootballMatch(){
        log.info("Get all football match info");
        return ResponseEntity.ok(footBallMatchService.findAllFootballMatch());
    }
    @GetMapping("/{id}")
    public ResponseEntity<FootballMatchCustomDto> getFootballMatchById(@PathVariable("id")Long id){
        log.info("Get football match by Id {}", id);
        return ResponseEntity.ok(footBallMatchService.findFootballMatchById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballMatchById(@PathVariable("id") Long id){
        log.info("Delete account by Id {}", id);
        footBallMatchService.deleteFootballMatchById(id);
        String message = "Football Match with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();
    }
    @PostMapping("/{teamId}")
    public ResponseEntity<FootballMatchCustomDto> createFootballMatch(@RequestBody FootballMatchDto footballMatchDto, @PathVariable("teamId") Long teamId){
        log.info("create football match base on home team {}",teamId);
        FootballMatchCustomDto footballMatchCustomDto  =footBallMatchService.createFootballMatch(footballMatchDto,teamId);
        return ResponseEntity.created(URI.create("/project/footballmatchs/").resolve(footballMatchCustomDto.getHomeTeamName())).body(footballMatchCustomDto);
    }
}
