package com.axonactive.personalproject.authenticate;

import com.axonactive.personalproject.jwt.LoginRequest;
import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest);

    @PostMapping("/signup/{customerId}")
    ResponseEntity<AccountDto> registerAccount(@Valid @RequestBody AccountDto accountDto, @PathVariable("customerId") Long customerId);

}
