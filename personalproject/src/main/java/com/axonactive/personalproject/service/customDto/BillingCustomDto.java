package com.axonactive.personalproject.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingCustomDto {
    private Long id;
    private Long accountId;
    private Double total_bet;
    private LocalDate betDate;
}
