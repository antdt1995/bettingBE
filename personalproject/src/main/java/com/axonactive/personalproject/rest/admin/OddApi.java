package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/odds")
public interface OddApi {
    @GetMapping
    ResponseEntity<List<OddCustomDto>> getAllOdd();
    @GetMapping("/{id}")
    ResponseEntity<OddCustomDto> findOddById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOddById(@PathVariable("id") Long id);
    @PostMapping("/{matchId}/{typeId}")
    ResponseEntity<OddCustomDto> createOdd(@RequestBody OddDto oddDto,@PathVariable("matchId") Long matchId,@PathVariable("typeId") Long typeId);
    @PutMapping("/{id}")
    ResponseEntity<OddCustomDto> updateOdd(@RequestBody OddDto oddDto,@PathVariable("id") Long id);
}
