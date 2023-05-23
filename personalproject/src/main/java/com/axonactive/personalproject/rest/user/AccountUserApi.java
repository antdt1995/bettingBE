package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bet/accounts/user")
public interface AccountUserApi {
    @GetMapping("/{id}")
    ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id);
    @PutMapping("/{accountId}")
    ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto, @PathVariable("accountId") Long accountId);
}
