package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.InvoiceDetailApi;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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
    public ResponseEntity<InvoiceDetailDto> getInvoiceDetailById(Long id) {
        return ResponseEntity.ok(invoiceDetailService.getInvoiceDetailById(id));
    }

    @Override
    public ResponseEntity<Void> deleteInvoiceDetail(Long id) {
        log.debug("--> Request Delete invoice detail {}", id);
        invoiceDetailService.deleteInvoiceDetail(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<InvoiceDetailDto> createInvoiceDetail(InvoiceDetailDto invoiceDetailDto, Long invoiceId) {
        log.debug("--> Request create invoice detail{}",invoiceId);
        InvoiceDetailDto invoiceDetailDto1=invoiceDetailService.createInvoiceDetail(invoiceDetailDto,invoiceId);
        return ResponseEntity.created(URI.create("/bet/invoicedetails/"+invoiceDetailDto.getId())).body(invoiceDetailDto1 );
    }
}
