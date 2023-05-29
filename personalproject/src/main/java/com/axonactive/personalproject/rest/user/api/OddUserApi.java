package com.axonactive.personalproject.rest.user.api;

import com.axonactive.personalproject.service.customDto.OddCustomDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/bet/user/odds")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public interface OddUserApi {
    @GetMapping("/match/{matchId}")
    ResponseEntity<List<OddCustomDto>> findOddByMatchId(@PathVariable("matchId") Long matchId);
}
