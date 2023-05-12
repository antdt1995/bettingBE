package com.axonactive.personalproject.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetailCustomDto {
    private Long oddId;
    private Long billId;
    private Double betAmount;
}
