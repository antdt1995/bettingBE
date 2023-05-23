package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.dto.HouseDto;

import java.util.List;

public interface HouseService {
    List<HouseDto> getAllHouse();
    HouseDto findHouseById(Long id);
    void deleteHouseById(Long id);
    HouseDto createHouse(HouseDto houseDto);
    HouseDto updateHouse(HouseDto houseDto,Long id);
}
