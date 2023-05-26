package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.OddTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/bet/oddtypes")
@PreAuthorize("hasRole('ADMIN')")
public interface OddTypeApi {
    @GetMapping
    ResponseEntity<List<OddTypeDto>> getAllOddType();
    @GetMapping("/{id}")
    ResponseEntity<OddTypeDto> findOddTypeById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteOddTypeById(@PathVariable("id") Long id);
    @PostMapping
    ResponseEntity<OddTypeDto> createOddType(@RequestBody OddTypeDto oddTypeDto);
    @PutMapping
    ResponseEntity<OddTypeDto> updateOddType(@RequestBody OddTypeDto oddTypeDto,@PathVariable("id") Long id);
}
