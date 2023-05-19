package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.service.customDto.InvoiceCustomDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceCustomDto> getAllInvoice();
    InvoiceCustomDto getInvoiceById(Long id);
    void deleteAccount(Long id);
    InvoiceCustomDto updateInvoice(InvoiceDto invoiceDto, Long invoiceId);
    InvoiceCustomDto createInvoice(InvoiceDto invoiceDto, Long accountId);
}
