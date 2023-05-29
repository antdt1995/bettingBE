package com.axonactive.personalproject.rest.user.api;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
@RequestMapping("/bet/user/footballmatchs/")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")

public interface FootballMatchUserApi {
    @GetMapping
    ResponseEntity<List<FootballMatchCustomDto>> getAllFootballMatch();

    @GetMapping("/{id}")
    ResponseEntity<FootballMatchCustomDto> getFootballMatchById(@PathVariable("id") Long id);
    @GetMapping("/matchlistbydate")
    ResponseEntity<List<FootballMatchWithTotalBet>> getAllMatchWithTotalBetBetweenDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fromDate,
                                                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate);

}
