package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.FootballMatchUserApi;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FootballMatchUserResources implements FootballMatchUserApi {
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
    public ResponseEntity<List<FootballMatchWithTotalBet>> getAllMatchWithTotalBetBetweenDate(LocalDate fromDate, LocalDate endDate) {
        return ResponseEntity.ok(footBallMatchService.getAllMatchWithTotalBetBetweenDate(fromDate, endDate));
    }

    @Override
    public ResponseEntity<List<AccountDto>> findAccountByMatchId(Long matchId) {
        return ResponseEntity.ok(footBallMatchService.findAccountByMatchId(matchId));
    }

    @Override
    public ResponseEntity<HouseDto> findHouse() {
        return ResponseEntity.ok(footBallMatchService.findHouse());
    }

}
