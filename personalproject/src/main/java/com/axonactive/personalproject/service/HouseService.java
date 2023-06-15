package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.AccountAndMaxWinInYear;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;

import java.time.LocalDate;
import java.util.List;

public interface HouseService {
    List<HouseDto> getAllHouse();
    HouseDto findHouseById(Long id);
    void deleteHouseById(Long id);
    HouseDto createHouse(HouseDto houseDto);
    HouseDto updateHouse(HouseDto houseDto,Long id);

    void paidInterest(Long invoiceDetailId);

    List<IdAndTotalBet> findWinAccountByMatchId(Long matchId);
    List<IdAndTotalBet> findLoseAccountByMatchId(Long matchId);
    Double calcWinAmount(Long invoiceId);
    Long findWinOverUnderOddId(Long matchId);
    List<AccountAndMaxWinInYear> findAccountWinMostMoneyInYear(LocalDate inputYear, Long input, Long matchId);
}
