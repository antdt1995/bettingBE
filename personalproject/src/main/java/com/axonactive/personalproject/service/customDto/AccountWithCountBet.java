package com.axonactive.personalproject.service.customDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountWithCountBet {
    private String userName;
    private Long numberOfBet;
}
