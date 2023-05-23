package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseDto {
    @JsonIgnore
    private Long id;
    private String name;
    private String address;
    private Double balance;

}
