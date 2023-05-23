package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String userName;
    @JsonIgnore
    private String userPassword;
    private Double totalBalance;
    private String email;

}
