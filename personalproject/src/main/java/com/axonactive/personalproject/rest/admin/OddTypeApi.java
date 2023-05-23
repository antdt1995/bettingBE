package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.OddTypeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/auth/oddtypes")
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
