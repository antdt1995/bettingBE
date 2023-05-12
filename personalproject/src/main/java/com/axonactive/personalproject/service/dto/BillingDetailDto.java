package com.axonactive.personalproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDetailDto {
    private Long id;
    private Double betAmount;
}
