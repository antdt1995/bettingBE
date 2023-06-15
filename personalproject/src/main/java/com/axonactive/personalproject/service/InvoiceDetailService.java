package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.House;

import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface InvoiceDetailService {
    List<InvoiceDetailDto> getAllInvoiceDetail();
    InvoiceDetailDto getInvoiceDetailById(Long id);
    void deleteInvoiceDetail(Long id);
    Double totalBetAmount(Long invoiceId);
    List<InvoiceDetailDto> createInvoiceDetail(List<InvoiceDetailDto> invoiceDetailDto);
    House findHouseByInvoiceid(Long invoiceId);
    List<InvoiceDetail> getInvoiceByMatchId(Long matchId);
    List<IdAndTotalBet> totalBetAmountByMatchId(@Param("matchId") Long matchId);
}
