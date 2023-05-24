package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.InvoiceDto;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/invoices")
public interface InvoiceApi {
    @GetMapping
    ResponseEntity<List<InvoiceDto>> getAllInvoice();
    @GetMapping("/{id}")
    ResponseEntity<InvoiceDto> getInvoiceById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id);
    @PostMapping("/{accountId}")
    ResponseEntity<InvoiceDto> createInvoice(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) InvoiceDto invoiceDto,
                                             @PathVariable("accountId") Long accountId);
}
