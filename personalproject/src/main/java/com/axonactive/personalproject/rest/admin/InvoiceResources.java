package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.InvoiceApi;
import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvoiceResources implements InvoiceApi{
    private final InvoiceService invoiceService;
    @Override
    public ResponseEntity<List<InvoiceDto>> getAllInvoice() {
        return ResponseEntity.ok(invoiceService.getAllInvoice());
    }


    @Override
    public ResponseEntity<Void> deleteInvoice(Long id) {
        log.debug("--> Request Delete invoice id{}",id);
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().header("Delete Invoice Success").build();
    }

}
