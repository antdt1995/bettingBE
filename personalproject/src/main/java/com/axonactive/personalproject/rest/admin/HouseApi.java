package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.HouseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/houses")
public interface HouseApi {
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
}
