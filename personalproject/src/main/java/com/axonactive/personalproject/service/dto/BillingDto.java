package com.axonactive.personalproject.service.dto;

import com.axonactive.personalproject.entity.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingDto {
    private Long id;
    private Double total_bet;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate betDate;
}
