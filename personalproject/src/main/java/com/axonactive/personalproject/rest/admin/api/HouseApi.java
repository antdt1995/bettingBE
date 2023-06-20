package com.axonactive.personalproject.rest.admin.api;

import com.axonactive.personalproject.service.customDto.AccountAndMaxWinInYear;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

//@RequestMapping("/bet/admin/houses")
//@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/public/houses")
public interface HouseApi {
    @PostMapping("/complete/{matchId}")
    ResponseEntity<Void> completePayment(Long matchId);
    @GetMapping
    ResponseEntity<List<HouseDto>> getAllHouse();
    @GetMapping("/{id}")
    ResponseEntity<HouseDto> findHouseById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteHouseById(@PathVariable("id") Long id);
    @PostMapping
    ResponseEntity<HouseDto> createHouse(@RequestBody HouseDto houseDto);
    @PutMapping("/{id}")
    ResponseEntity<HouseDto> updateHouse(@RequestBody HouseDto houseDto,@PathVariable("id") Long id);
    @GetMapping("/accountwinlist")
    ResponseEntity<List<IdAndTotalBet>> findWinAccountByMatchId(@RequestParam("matchId") Long matchId);
    @GetMapping("/accountloselist")
    ResponseEntity<List<IdAndTotalBet>> findLoseAccountByMatchId(@RequestParam("matchId") Long matchId);
    @GetMapping("/accountmostwin")
    ResponseEntity<List<AccountAndMaxWinInYear>> findAccountWinMostMoneyInYear(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)  LocalDate inputYear,
                                                                               @RequestParam Long input,
                                                                               @RequestParam Long matchId);
    @GetMapping("/housewinbymatchID/{matchId}")
    ResponseEntity<List<Double>> calcWinAmount(@PathVariable("matchId") Long matchId);
}
