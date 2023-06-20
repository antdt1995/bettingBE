package com.axonactive.personalproject.service.dto;

import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDto {

    private Long id;
    private Long accountId;
    private Double totalBet;
}
