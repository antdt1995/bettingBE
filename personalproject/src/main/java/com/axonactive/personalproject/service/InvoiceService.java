package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.service.customDto.InvoiceWithInvoiceDetailsDto;
import com.axonactive.personalproject.service.dto.InvoiceDto;

import java.util.List;

public interface InvoiceService {
    List<InvoiceDto> getAllInvoice();
    InvoiceDto getInvoiceById(Long id);
    void deleteInvoice(Long id);
    List<InvoiceWithInvoiceDetailsDto> getInvoiceByUsername(String token);
}
