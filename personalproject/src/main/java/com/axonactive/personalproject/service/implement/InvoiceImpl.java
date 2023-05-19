package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.customDto.InvoiceCustomDto;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceImpl implements InvoiceService {
    @Override
    public List<InvoiceCustomDto> getAllInvoice() {
        return null;
    }

    @Override
    public InvoiceCustomDto getInvoiceById(Long id) {
        return null;
    }

    @Override
    public void deleteAccount(Long id) {

    }

    @Override
    public InvoiceCustomDto updateInvoice(InvoiceDto invoiceDto, Long invoiceId) {
        return null;
    }

    @Override
    public InvoiceCustomDto createInvoice(InvoiceDto invoiceDto, Long accountId) {
        return null;
    }
}
