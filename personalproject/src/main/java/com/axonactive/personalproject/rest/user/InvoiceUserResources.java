package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.InvoiceUserApi;
import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvoiceUserResources implements InvoiceUserApi {
    private final InvoiceService invoiceService;

    @Override
    public ResponseEntity<InvoiceDto> getInvoiceById(Long id) {
        return ResponseEntity.ok(invoiceService.getInvoiceById(id));
    }

}
