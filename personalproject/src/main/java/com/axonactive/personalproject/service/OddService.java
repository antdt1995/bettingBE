package com.axonactive.personalproject.service;


import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;

import java.util.List;

public interface OddService {
    List<OddCustomDto> getAllOdd();
    OddCustomDto findOddById(Long id);
    void deleteOddById(Long id);
    OddCustomDto createOdd(OddDto oddDto, Long matchId, Long typeId);
    OddCustomDto updateOdd(OddDto oddDto,Long id);
}
