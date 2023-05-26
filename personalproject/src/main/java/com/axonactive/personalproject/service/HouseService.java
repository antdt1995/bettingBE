package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.AccountAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;

import java.util.List;

public interface HouseService {
    List<HouseDto> getAllHouse();
    HouseDto findHouseById(Long id);
    void deleteHouseById(Long id);
    HouseDto createHouse(HouseDto houseDto);
    HouseDto updateHouse(HouseDto houseDto,Long id);
    List<AccountAndTotalBet> findWinAccountByMatchId(Long matchId);
    List<AccountAndTotalBet> findLoseAccountByMatchId(Long matchId);

    void paidInterest(Long invoiceId, Long houseId);
    Double calcWin(Long invoiceId);
    Long findWinOverUnderOddId(Long matchId);
}
