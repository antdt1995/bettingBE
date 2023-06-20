package com.axonactive.personalproject.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @JsonIgnore
    private Long id;
    private String userName;
    @JsonIgnore
    private String Password;
    private Double totalBalance;
    private String email;
    private String lastName;
    private String firstName;
    private String phone;
    private String bankName;
    private String bankAccount;



}
