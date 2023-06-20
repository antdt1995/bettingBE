package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.HouseApi;
import com.axonactive.personalproject.service.HouseService;
import com.axonactive.personalproject.service.customDto.AccountAndMaxWinInYear;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HouseResources implements HouseApi {
    private final HouseService houseService;

    @Override
    public ResponseEntity<Void> completePayment(Long matchId) {
        houseService.completePayment(matchId);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<List<HouseDto>> getAllHouse() {
       log.info("get all house");
        return ResponseEntity.ok(houseService.getAllHouse());
    }

    @Override
    public ResponseEntity<HouseDto> findHouseById(Long id) {
        log.info("get house by id");
        return ResponseEntity.ok(houseService.findHouseById(id));
    }

    @Override
    public ResponseEntity<Void> deleteHouseById(Long id) {
        log.debug("--> Request delete house id {}", id);
        houseService.deleteHouseById(id);
        return ResponseEntity.noContent().header("DeleteSuccess","Delete house success").build();
    }

    @Override
    public ResponseEntity<HouseDto> createHouse(HouseDto houseDto) {
        log.debug("--> Request create new house");
        HouseDto houseDto1=houseService.createHouse(houseDto);
        return ResponseEntity.created(URI.create("/bet/houses/"+houseDto.getId())).body(houseDto1);
    }

    @Override
    public ResponseEntity<HouseDto> updateHouse(HouseDto houseDto, Long id) {
        log.debug("--> Request update house");
        return ResponseEntity.ok().body(houseService.updateHouse(houseDto,id));
    }

    @Override
    public ResponseEntity<List<IdAndTotalBet>> findWinAccountByMatchId(Long matchId) {
        return ResponseEntity.ok(houseService.findWinAccountByMatchId(matchId));
    }

    @Override
    public ResponseEntity<List<IdAndTotalBet>> findLoseAccountByMatchId(Long matchId) {
        return ResponseEntity.ok(houseService.findLoseAccountByMatchId(matchId));
    }

    @Override
    public ResponseEntity<List<AccountAndMaxWinInYear>> findAccountWinMostMoneyInYear(LocalDate inputYear, Long input, Long matchId) {
        return ResponseEntity.ok().body(houseService.findAccountWinMostMoneyInYear(inputYear,input,matchId));
    }

    @Override
    public ResponseEntity<List<Double>> calcWinAmount(Long matchId) {
        return ResponseEntity.ok(houseService.houseMinimumWin(matchId));
    }
}
