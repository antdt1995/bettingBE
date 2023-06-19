package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.admin.api.OddApi;
import com.axonactive.personalproject.rest.user.api.OddUserApi;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class OddUserResources implements OddUserApi {
    private final OddService oddService;

    @Override
    public ResponseEntity<List<OddCustomDto>> findOddByMatchId(Long matchId) {
        log.info("Create odd");
        return ResponseEntity.ok(oddService.findOddByMatchId(matchId));
    }

    @Override
    public ResponseEntity<List<Double>> findTotalBetAmountOfEachOddByMatchID(Long matchId) {
        return ResponseEntity.ok(oddService.findTotalBetAmountOfEachOddByMatchID(matchId));
    }
}
