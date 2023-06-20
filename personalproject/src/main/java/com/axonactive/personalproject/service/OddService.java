package com.axonactive.personalproject.service;


import com.axonactive.personalproject.service.customDto.OddCustomDto;
import com.axonactive.personalproject.service.dto.OddDto;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OddService {
    List<OddCustomDto> getAllOdd();
    OddCustomDto findOddById(Long id);
    void deleteOddById(Long id);
    OddCustomDto createOdd(OddDto oddDto,Long houseId, Long matchId, Long typeId);
    OddCustomDto updateOdd(OddDto oddDto,Long id);
    List<OddCustomDto> findOddByMatchId(@Param("matchId") Long matchId);

    //for back end only
    Long findWinOddIds(@Param("matchId")Long matchId);
    Long findOverOddId(@Param("matchId") Long matchId);
    Long findUnderOddId(@Param("matchId") Long matchId);
    List<Double> findTotalBetAmountOfEachOddByMatchID(@Param("matchId") Long matchId);

    void deleteOddsByMatchID(List<Long> oddIDs);
}
