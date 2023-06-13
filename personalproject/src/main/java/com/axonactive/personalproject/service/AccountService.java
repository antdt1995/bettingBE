package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.customDto.AccountWithCountBet;
import com.axonactive.personalproject.service.customDto.AccountWithMaxBet;
import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AccountService {
    List<AccountDto> getAllAccount();
    AccountDto getAccountById(Long id);
    void deleteAccount(Long id);
    AccountDto updateAccount(AccountDto accountDto);
    CustomRegisterDto createAccount(CustomRegisterDto customRegisterDto);
    List<AccountWithMaxBet> accountWithMaxBet(int limit, Pageable pageable);
    List<AccountWithCountBet> accountWithCountBet(int limit, Pageable pageable);
}
