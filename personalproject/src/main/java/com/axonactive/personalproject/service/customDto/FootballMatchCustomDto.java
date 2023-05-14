package com.axonactive.personalproject.service.customDto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
}
