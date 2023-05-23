package com.axonactive.personalproject.service;


import com.axonactive.personalproject.service.dto.OddTypeDto;

import java.util.List;

public interface OddTypeService {
    List<OddTypeDto> getAllOddType();
    OddTypeDto findOddTypeById(Long id);
    void deleteOddTypeById(Long id);
    OddTypeDto createOddType(OddTypeDto oddTypeDto);
    OddTypeDto updateOddType(OddTypeDto oddTypeDto,Long id);
}
