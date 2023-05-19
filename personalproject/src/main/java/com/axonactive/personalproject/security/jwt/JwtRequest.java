package com.axonactive.personalproject.security.jwt;

import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest implements Serializable {
    private String userName;
    private String password;
}
