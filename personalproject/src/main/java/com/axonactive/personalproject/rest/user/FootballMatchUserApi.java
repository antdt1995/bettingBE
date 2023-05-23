package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.customDto.FootballMatchCustomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
//@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
@RequestMapping("/auth/footballmatchs/")
public interface FootballMatchUserApi {
    @GetMapping
    ResponseEntity<List<FootballMatchCustomDto>> getAllFootballMatch();

    @GetMapping("/{id}")
    ResponseEntity<FootballMatchCustomDto> getFootballMatchById(@PathVariable("id") Long id);
}
