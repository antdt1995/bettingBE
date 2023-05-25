package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;


import java.util.List;

public interface InvoiceDetailService {
    List<InvoiceDetailDto> getAllInvoiceDetail();
    InvoiceDetailDto getInvoiceDetailById(Long id);
    void deleteInvoiceDetail(Long id);
    Double totalBetAmount(Long invoiceId);
    List<InvoiceDetailDto> createInvoiceDetail(List<InvoiceDetailDto> invoiceDetailDto, Long invoiceId);

}
