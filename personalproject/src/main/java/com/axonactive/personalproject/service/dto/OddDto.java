package com.axonactive.personalproject.service.dto;

import com.axonactive.personalproject.entity.OddType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OddDto {
    @JsonIgnore
    private Long id;
    private Double oddRate;
    private Long setScore;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
    private OddType oddType;

}
