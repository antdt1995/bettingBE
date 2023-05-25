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
import java.util.ArrayList;
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
        log.info("delete invoice detail {}",id);
        invoiceDetailService.deleteInvoiceDetail(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<InvoiceDetailDto>> createInvoiceDetail(List<InvoiceDetailDto> invoiceDetailDto, Long invoiceId) {
        log.debug("--> Request create invoice detail{}", invoiceId);
        log.info("Create invoice detail");
        List<InvoiceDetailDto> invoiceDetailDtoList = invoiceDetailService.createInvoiceDetail(invoiceDetailDto, invoiceId);
        List<URI> uris = new ArrayList<>();
        for (InvoiceDetailDto detailDto : invoiceDetailDto) {
            URI uri = URI.create("/bet/invoicedetails/" + detailDto.getId());
            uris.add(uri);
        }
        return ResponseEntity.created(uris.get(0)).body(invoiceDetailDtoList);
    }

    @Override
    public ResponseEntity<Long> findOverUnderOdd(Long matchId) {
        return null;
    }
}
