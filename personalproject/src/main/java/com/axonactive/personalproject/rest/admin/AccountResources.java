package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.AccountApi;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.customDto.AccountWithCountBet;
import com.axonactive.personalproject.service.customDto.AccountWithMaxBet;
import com.axonactive.personalproject.service.dto.AccountDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

public class AccountResources implements AccountApi {
    private final AccountService accountService;

    @Override
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        return ResponseEntity.ok().body(accountService.getAllAccount());
    }


    @Override
    public ResponseEntity<Void> deleteAccount(Long id) {
        log.debug("--> Request Delete account by Id ");
        accountService.deleteAccount(id);
        String message = "Account with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();

    }

    @Override
    public ResponseEntity<List<AccountWithMaxBet>> accountWithMaxBet(int limit, Pageable pageable) {
        return ResponseEntity.ok().body(accountService.accountWithMaxBet(limit, pageable));
    }

    @Override
    public ResponseEntity<List<AccountWithCountBet>> accountWithCountBet(int input, Pageable pageable) {
        return ResponseEntity.ok().body(accountService.accountWithCountBet(input, pageable));
    }

}
