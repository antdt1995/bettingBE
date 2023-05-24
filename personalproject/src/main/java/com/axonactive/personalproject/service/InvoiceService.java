package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDto> getAllInvoice();
    InvoiceDto getInvoiceById(Long id);
    void deleteInvoice(Long id);
    InvoiceDto createInvoice(InvoiceDto invoiceDto, Long accountId);

}
