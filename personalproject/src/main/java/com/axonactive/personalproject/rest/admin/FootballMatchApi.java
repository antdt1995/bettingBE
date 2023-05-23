package com.axonactive.personalproject.rest.admin;


import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/bet/footballmatchs")
public interface FootballMatchApi {


    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteFootballMatchById(@PathVariable("id") Long id);

    @PostMapping("/{homeId}/{awayId}")
    ResponseEntity<FootballMatchDto> createFootballMatch(@RequestBody FootballMatchDto footballMatchDto,
                                                         @PathVariable("homeId") Long homeId,
                                                         @PathVariable("awayId") Long awayId);
    @PutMapping("/{id}")
    ResponseEntity<FootballMatchDto> updateFootballMatch(@RequestBody FootballMatchDto footballMatchDto, @PathVariable("id") Long id);
}
