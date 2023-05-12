package com.axonactive.personalproject.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OddCustomDto {
    private String oddType;
    private String homeTeamName;
    private Double oddRate;
    private Long setScore;
    private LocalDate endDate;
}
