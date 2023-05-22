package com.axonactive.personalproject.jwt;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest implements Serializable {
    private String userName;
    private String password;
}
