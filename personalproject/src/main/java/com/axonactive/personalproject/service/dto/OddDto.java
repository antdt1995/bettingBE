package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OddDto {
    private Long id;
    private Double oddRate;
    private Long setScore;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;

}
