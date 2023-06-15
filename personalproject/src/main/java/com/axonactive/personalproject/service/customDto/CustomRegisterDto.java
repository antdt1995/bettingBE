package com.axonactive.personalproject.service.customDto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomRegisterDto {
    @JsonIgnore
    private Long id;
    private String userName;
    @JsonIgnore
    private String password;
    private Double totalBalance;
    private String email;
    private String lastName;
    private String firstName;
    private String phone;
}
