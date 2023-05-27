package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.AccountApi;
import com.axonactive.personalproject.rest.user.AccountUserApi;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.implement.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

public class AccountResources implements AccountApi, AccountUserApi {
    private final AccountService accountService;

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        return ResponseEntity.ok().body(accountService.getAllAccount());
    }

    @Override
    public ResponseEntity<AccountDto> getAccountById( Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok().body(accountDto);
    }

    @Override
    public ResponseEntity<Void> deleteAccount( Long id) {
        log.debug("--> Request Delete account by Id ");
        accountService.deleteAccount(id);
        String message = "Account with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();

    }

    @Override
    public ResponseEntity<AccountDto> updateAccount( AccountDto accountDto, Long accountId) {
        log.debug("--> Request Update account ");
        AccountDto account = accountService.updateAccount(accountDto, accountId);
        return ResponseEntity.ok().body(account);
    }

    @Override
    public ResponseEntity<List<Object[]>> accountWithMaxBet(Long input) {
        return ResponseEntity.ok().body(accountService.accountWithMaxBet(input));
    }

    @Override
    public ResponseEntity<List<Object[]>> accountWithCountBet(Long input) {
        return ResponseEntity.ok().body(accountService.accountWithCountBet(input));
    }
}
