package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.implement.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/project/accounts")
public class AccountResources {
    private final AccountServiceImpl accountService;

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount() {
        log.info("Get all account info");
        return ResponseEntity.ok().body(accountService.getAllAccount());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id) {
        log.info("Get account by Id ");
        AccountDto accountDto = accountService.getAccountById(id);
        try {
            return ResponseEntity.ok().body(accountDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        log.info("Delete account by Id ");
        accountService.deleteAccount(id);
        try {

            String message = "Account with ID " + id + " has been successfully deleted.";
            return ResponseEntity.noContent().header("Success", message).build();
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto, @PathVariable("accountId") Long accountId) {
        log.info("Update account ");
        AccountDto account = accountService.updateAccount(accountDto, accountId);
        try {

            return ResponseEntity.ok().body(account);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto, @PathVariable("customerId") Long customerId) {
        log.info("Create account on customer ");
        AccountDto account = accountService.createAccount(accountDto, customerId);
        try {

            return ResponseEntity.created(URI.create("/project/accounts/" + account.getId())).body(account);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }
}
