package com.axonactive.personalproject.rest.admin;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/bet/admin/footballmatchs")
public interface FootballMatchApi {


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteFootballMatchById(@PathVariable("id") Long id);

    @PostMapping("/{homeId}/{awayId}")
    ResponseEntity<FootballMatchDto> createFootballMatch(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) FootballMatchDto footballMatchDto,
                                                         @PathVariable("homeId") Long homeId,
                                                         @PathVariable("awayId") Long awayId);
    @PutMapping("/{id}")
    ResponseEntity<FootballMatchDto> updateFootballMatch(@RequestBody FootballMatchDto footballMatchDto, @PathVariable("id") Long id);
    @GetMapping("/matchlistbydate")
    ResponseEntity<List<Object[]>> getAllMatchWithTotalBetBetweenDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);
    @GetMapping("/matchlistbysumbet")
    ResponseEntity<List<Object[]>> getAllMatchByTotalBet(@RequestParam ("fromDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                            @RequestParam ("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                            @RequestParam ("input") Long input);
    @GetMapping("/matchlistbycountbet")
    ResponseEntity<List<Object[]>> getAllMatchByCountTotalBet(@RequestParam ("fromDate")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                         @RequestParam ("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                                                         @RequestParam ("input") Long input);
}
