package com.axonactive.personalproject.service.customDto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRoleAssignCustomDto {
    @JsonIgnore
    private Long id;
    private String userName;
    private String role;
}
