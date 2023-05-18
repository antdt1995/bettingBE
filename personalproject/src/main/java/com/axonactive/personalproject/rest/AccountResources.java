package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.implement.AccountServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumeric;
import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumericWithSpecial;

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
        if (id == null) {
            throw ProjectException.badRequest("IdIsNull", "Id is null, please enter");
        }
        AccountDto accountDto = accountService.getAccountById(id);
        if (accountDto == null) {
            throw ProjectException.AccountNotFound();
        }
        try {
            return ResponseEntity.ok().body(accountDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id) {
        log.info("Delete account by Id ");
        if (id == null) {
            throw ProjectException.AccountNotFound();
        }
        try {
            accountService.deleteAccount(id);
            String message = "Account with ID " + id + " has been successfully deleted.";
            return ResponseEntity.noContent().header("Success", message).build();
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountDto> updateAccount(@RequestBody AccountDto accountDto, @PathVariable("accountId") Long accountId) {
        log.info("Update account ");
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative", "Enter again");
        }
        if (!isAlphanumeric(accountDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(accountDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongUserPasswordFormat", "User should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (accountId == null) {
            throw ProjectException.AccountNotFound();
        }
        try {
            AccountDto account = accountService.updateAccount(accountDto, accountId);
            return ResponseEntity.ok().body(account);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PostMapping("/{customerId}")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto, @PathVariable("customerId") Long customerId) {
        log.info("Create account on customer ");
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative", "Enter again");
        }
        if (!isAlphanumeric(accountDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(accountDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongUserPasswordFormat", "User should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (customerId == null) {
            throw new ResponseException("InvalidId", "Invalid Id", HttpStatus.BAD_REQUEST);
        }
        try {
            AccountDto account = accountService.createAccount(accountDto, customerId);
            return ResponseEntity.created(URI.create("/project/accounts/" + account.getId())).body(account);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }
}
