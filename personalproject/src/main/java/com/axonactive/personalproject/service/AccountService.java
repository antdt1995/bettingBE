package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.service.dto.AccountDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    void deleteAccount(Long id);
    Account updateAccount(AccountDto accountDto, Long accountId);
    Account createAccount(AccountDto accountDto, Long customerId);
}
