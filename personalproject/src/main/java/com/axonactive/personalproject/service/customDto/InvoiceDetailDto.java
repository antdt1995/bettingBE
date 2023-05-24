package com.axonactive.personalproject.service.customDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDetailDto {
    @JsonIgnore
    private Long id;
    private Long oddId;
    private Long invoiceId;
    private Double betAmount;
}
