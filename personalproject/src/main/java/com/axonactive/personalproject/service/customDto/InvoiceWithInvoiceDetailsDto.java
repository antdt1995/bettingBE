package com.axonactive.personalproject.service.customDto;

import com.axonactive.personalproject.service.dto.InvoiceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceWithInvoiceDetailsDto {
    private Long id;
    private Long accountId;
    private Double totalBet;
    private List<InvoiceDetailDto> invoiceDetails;

}
