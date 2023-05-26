package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.dto.InvoiceDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bet/user/invoices")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")

public interface InvoiceUserApi {
    @PostMapping("/{accountId}")
    ResponseEntity<InvoiceDto> createInvoice(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) InvoiceDto invoiceDto,
                                             @PathVariable("accountId") Long accountId);
    @GetMapping("/{id}")
    ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable("id") Long id);
}
