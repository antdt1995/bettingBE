package com.axonactive.personalproject.rest.admin.api;

import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/admin/invoicedetails")
@PreAuthorize("hasRole('ADMIN')")
public interface InvoiceDetailApi {
    @GetMapping
    ResponseEntity<List<InvoiceDetailDto>> getAllInvoiceDetail();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteInvoiceDetail(@PathVariable("id") Long id);

}
