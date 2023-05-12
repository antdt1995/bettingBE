package com.axonactive.personalproject.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballMatchCustomDto {
    private String homeTeamName;
    private Long homeScore;
    private String awayTeamName;
    private Long awayScore;
    private Long totalScore;
    private LocalDate startDate;
}
