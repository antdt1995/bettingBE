package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.InvoiceDetailApi;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvoiceDetailResources implements InvoiceDetailApi {
    private final InvoiceDetailService invoiceDetailService;

    @Override
    public ResponseEntity<List<InvoiceDetailDto>> getAllInvoiceDetail() {
        return ResponseEntity.ok(invoiceDetailService.getAllInvoiceDetail());
    }


    @Override
    public ResponseEntity<Void> deleteInvoiceDetail(Long id) {
        log.debug("--> Request Delete invoice detail {}", id);
        log.info("delete invoice detail {}",id);
        invoiceDetailService.deleteInvoiceDetail(id);
        return ResponseEntity.noContent().build();
    }

}
