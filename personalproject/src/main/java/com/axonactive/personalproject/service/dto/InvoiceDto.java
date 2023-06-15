package com.axonactive.personalproject.service.dto;

import com.axonactive.personalproject.entity.InvoiceDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    private Long accountId;
    private Double totalBet;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDateTime betDate;
}
