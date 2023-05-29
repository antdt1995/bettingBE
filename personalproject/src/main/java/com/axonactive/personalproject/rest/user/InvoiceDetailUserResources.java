package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.InvoiceDetailUserApi;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class InvoiceDetailUserResources implements InvoiceDetailUserApi {
    private final InvoiceDetailService invoiceDetailService;

    @Override
    public ResponseEntity<InvoiceDetailDto> getInvoiceDetailById(Long id) {
        log.info("Get invoice detail");
        return ResponseEntity.ok(invoiceDetailService.getInvoiceDetailById(id));
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


}
