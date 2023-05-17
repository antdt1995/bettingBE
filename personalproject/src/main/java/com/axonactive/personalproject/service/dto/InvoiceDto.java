package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {
    private Long id;
    private Double totalBet;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate betDate;
}
