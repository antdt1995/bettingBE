package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<FootballMatchCustomDto>> getAllFootballMatch() {
        log.info("Get all football match info");
        List<FootballMatchCustomDto> footballMatchCustomDto = footBallMatchService.findAllFootballMatch();
        try {
            return ResponseEntity.ok(footballMatchCustomDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<FootballMatchCustomDto> getFootballMatchById(@PathVariable("id") Long id) {
        log.info("Get football match by Id ");
        FootballMatchCustomDto footballMatchCustomDto = footBallMatchService.findFootballMatchById(id);
        try {
            return ResponseEntity.ok(footballMatchCustomDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballMatchById(@PathVariable("id") Long id) {
        log.info("Delete account by Id ");
        footBallMatchService.deleteFootballMatchById(id);
        try {
            String message = "Football Match with ID " + id + " has been successfully deleted.";
            return ResponseEntity.noContent().header("Success", message).build();
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PostMapping("/{homeId}/{awayId}")
    public ResponseEntity<FootballMatchDto> createFootballMatch(@RequestBody FootballMatchDto footballMatchDto,
                                                                @PathVariable("homeId") Long homeId,
                                                                @PathVariable("awayId") Long awayId) {
        log.info("create football match base on home team ");
        FootballMatchDto footballMatchDtos = footBallMatchService.createFootballMatch(footballMatchDto, homeId, awayId);
        try {
            return ResponseEntity.created(URI.create("/project/footballmatchs/" + footballMatchDtos.getId())).body(footballMatchDtos);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FootballMatchDto> updateFootballMatch(@RequestBody FootballMatchDto footballMatchDto, @PathVariable("id") Long id) {
        log.info("update football match id{}", id);
        FootballMatchDto footballMatchDto1 = footBallMatchService.updateFootballMatch(footballMatchDto, id);
        try {
            return ResponseEntity.ok().body(footballMatchDto1);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }


}
