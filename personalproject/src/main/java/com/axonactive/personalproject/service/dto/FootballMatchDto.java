package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatchDto {
    private Long id;
    private Long homeScore;
    private Long awayScore;
    private Long totalScore;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;

}
