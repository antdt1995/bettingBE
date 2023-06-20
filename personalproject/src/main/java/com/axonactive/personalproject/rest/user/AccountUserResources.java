package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.AccountUserApi;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j

public class AccountUserResources implements AccountUserApi {
    private final AccountService accountService;


    @Override
    public ResponseEntity<AccountDto> getAccountById() {
        AccountDto accountDto = accountService.getAccountById();
        return ResponseEntity.ok().body(accountDto);
    }


    @Override
    public ResponseEntity<AccountDto> updateAccount( AccountDto accountDto) {
        log.debug("--> Request Update account ");
        AccountDto account = accountService.updateAccount(accountDto);
        return ResponseEntity.ok().body(account);
    }


}
