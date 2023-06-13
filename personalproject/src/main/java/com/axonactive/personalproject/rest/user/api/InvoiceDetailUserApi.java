package com.axonactive.personalproject.rest.user.api;

import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/bet/user/invoicedetails")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")

public interface InvoiceDetailUserApi {
    @PostMapping
    ResponseEntity<List<InvoiceDetailDto>> createInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDetailDto);
    @GetMapping("/{id}")
    ResponseEntity<InvoiceDetailDto> getInvoiceDetailById(@PathVariable("id") Long id);
}
