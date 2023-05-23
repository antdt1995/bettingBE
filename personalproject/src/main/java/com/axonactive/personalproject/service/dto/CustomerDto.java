package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    @JsonIgnore
    private Long id;
    private String lastName;
    private String firstName;
    private String phone;

}
