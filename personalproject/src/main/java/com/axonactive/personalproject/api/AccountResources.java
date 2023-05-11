package com.axonactive.personalproject.api;

import com.axonactive.personalproject.entity.Account;
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
@RequestMapping("/project/accounts")
public class AccountResources {
    private final AccountServiceImpl accountService;
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccount(){
        log.info("Get all account info");
        return ResponseEntity.ok().body(accountService.getAllAccount());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long id){
        log.info("Get account by Id {}", id);
        return ResponseEntity.ok().body(accountService.getAccountById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id){
        log.info("Delete account by Id {}",id);
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{accountId}")
    public ResponseEntity<Account> updateAccount(@RequestBody AccountDto accountDto,@PathVariable("accountId")  Long accountId){
        log.info("Update account {}",accountId);
        Account account=accountService.updateAccount(accountDto,accountId);
        return ResponseEntity.ok().body(account);
    }
    @PostMapping("/{customerId}")
    public ResponseEntity<Account> createAccount(@RequestBody AccountDto accountDto,@PathVariable("customerId") Long customerId){
        log.info("Create account on customer {}",customerId);
        Account account=accountService.createAccount(accountDto,customerId);
        return ResponseEntity.ok().body(account);
    }








}
