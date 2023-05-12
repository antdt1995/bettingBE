package com.axonactive.personalproject.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FootballTeamDto {
    private Long id;
    private String name;
    private String league;
    private String manager;

}
