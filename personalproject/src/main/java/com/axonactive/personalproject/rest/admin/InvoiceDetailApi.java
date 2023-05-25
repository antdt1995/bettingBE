package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/invoicedetail")
public interface InvoiceDetailApi {
    @GetMapping
    ResponseEntity<List<InvoiceDetailDto>> getAllInvoiceDetail();
    @GetMapping("/{id}")
    ResponseEntity<InvoiceDetailDto> getInvoiceDetailById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteInvoiceDetail(@PathVariable("id") Long id);
    @PostMapping("/{invoiceId}")
    ResponseEntity<List<InvoiceDetailDto>> createInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDetailDto
                                                        ,@PathVariable("invoiceId") Long invoiceId);
    @GetMapping("/win")
    ResponseEntity<Long> findOverUnderOdd(@RequestParam Long matchId);
}
