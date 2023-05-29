package com.axonactive.personalproject.rest.user.api;

import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/bet/users/invoicedetails")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")

public interface InvoiceDetailUserApi {
    @PostMapping("/{invoiceId}")
    ResponseEntity<List<InvoiceDetailDto>> createInvoiceDetail(@RequestBody List<InvoiceDetailDto> invoiceDetailDto
            , @PathVariable("invoiceId") Long invoiceId);
    @GetMapping("/{id}")
    ResponseEntity<InvoiceDetailDto> getInvoiceDetailById(@PathVariable("id") Long id);
}
