package com.axonactive.personalproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatchDto {
    private String homeTeamName;
    private Long homeScore;
    private String awayTeamName;
    private Long awayScore;
    private Long totalScore;
    private LocalDate startDate;

}
