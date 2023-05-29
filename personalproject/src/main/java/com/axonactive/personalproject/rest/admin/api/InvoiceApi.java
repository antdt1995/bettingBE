package com.axonactive.personalproject.rest.admin.api;

import com.axonactive.personalproject.service.dto.InvoiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/admin/invoices")
@PreAuthorize("hasRole('ADMIN')")
public interface InvoiceApi {
    @GetMapping
    ResponseEntity<List<InvoiceDto>> getAllInvoice();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteInvoice(@PathVariable("id") Long id);

}
