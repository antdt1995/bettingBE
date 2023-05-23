package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.CustomerDto;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    void deleteAccount(Long id);
    AccountDto updateAccount(AccountDto accountDto, Long accountId);
    CustomRegisterDto createAccount(CustomRegisterDto customRegisterDto);
}
