package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.FootballMatchApi;
import com.axonactive.personalproject.rest.user.FootballMatchUserApi;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;

import com.axonactive.personalproject.service.dto.FootballMatchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FootballMatchResources implements FootballMatchApi , FootballMatchUserApi {
    private final FootBallMatchService footBallMatchService;

    @Override
    public ResponseEntity<List<FootballMatchCustomDto>> getAllFootballMatch() {
        List<FootballMatchCustomDto> footballMatchCustomDto = footBallMatchService.findAllFootballMatch();
        return ResponseEntity.ok(footballMatchCustomDto);
    }

    @Override
    public ResponseEntity<FootballMatchCustomDto> getFootballMatchById(Long id) {
        FootballMatchCustomDto footballMatchCustomDto = footBallMatchService.findFootballMatchById(id);
        return ResponseEntity.ok(footballMatchCustomDto);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFootballMatchById(Long id) {
        log.debug("--> Request Delete account by Id ");
        footBallMatchService.deleteFootballMatchById(id);
        String message = "Football Match with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();
    }

    @Override
    public ResponseEntity<FootballMatchDto> createFootballMatch(FootballMatchDto footballMatchDto,
                                                                Long homeId,
                                                                Long awayId) {
        log.debug("--> Request create football match base on home team ");
        FootballMatchDto footballMatchDtos = footBallMatchService.createFootballMatch(footballMatchDto, homeId, awayId);
        return ResponseEntity.created(URI.create("/bet/footballmatchs/" + footballMatchDtos.getId())).body(footballMatchDtos);
    }


    public ResponseEntity<FootballMatchDto> updateFootballMatch(FootballMatchDto footballMatchDto, Long id) {
        log.debug("--> Request update football match id{}", id);
        FootballMatchDto footballMatchDto1 = footBallMatchService.updateFootballMatch(footballMatchDto, id);
        return ResponseEntity.ok().body(footballMatchDto1);
    }

    @Override
    public ResponseEntity<List<Object[]>> getAllMatchWithTotalBetBetweenDate(LocalDate fromDate, LocalDate endDate) {
        return ResponseEntity.ok(footBallMatchService.getAllMatchWithTotalBetBetweenDate(fromDate,endDate));
    }

    @Override
    public ResponseEntity<List<Object[]>> getAllMatchByTotalBet(LocalDate fromDate, LocalDate endDate, Long input) {
        return ResponseEntity.ok(footBallMatchService.getAllMatchByTotalBet(fromDate,endDate,input));
    }

    @Override
    public ResponseEntity<List<Object[]>> getAllMatchByCountTotalBet(LocalDate fromDate, LocalDate endDate, Long input) {
        return ResponseEntity.ok(footBallMatchService.getAllMatchByCountTotalBet(fromDate,endDate,input));
    }
}
