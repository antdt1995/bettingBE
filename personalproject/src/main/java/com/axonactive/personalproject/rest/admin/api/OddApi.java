package com.axonactive.personalproject.rest.admin.api;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/admin/odds")
@PreAuthorize("hasRole('ADMIN')")
public interface OddApi {
    @GetMapping
    ResponseEntity<List<OddCustomDto>> getAllOdd();

    @GetMapping("/{id}")
    ResponseEntity<OddCustomDto> findOddById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOddById(@PathVariable("id") Long id);

    @PostMapping("/{houseId}/{matchId}/{typeId}")
    ResponseEntity<OddCustomDto> createOdd(@RequestBody OddDto oddDto,@PathVariable("houseId") Long houseId, @PathVariable("matchId") Long matchId, @PathVariable("typeId") Long typeId);

    @PutMapping("/{id}")
    ResponseEntity<OddCustomDto> updateOdd(@RequestBody OddDto oddDto, @PathVariable("id") Long id);

    @GetMapping("/totalbetamount/{matchId}")
    ResponseEntity<List<Double>> findTotalBetAmountOfEachOddByMatchID(@PathVariable("matchId") Long matchId);
}
