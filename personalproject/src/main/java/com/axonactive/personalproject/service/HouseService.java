package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.AccountAndMaxWinInYear;
import com.axonactive.personalproject.service.customDto.AccountAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;

import java.time.LocalDate;
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
    Double calcWinAmount(Long invoiceId);
    Long findWinOverUnderOddId(Long matchId);
    List<AccountAndMaxWinInYear> findAccountWinMostMoneyInYear(LocalDate inputYear, Long input, Long matchId);
}
