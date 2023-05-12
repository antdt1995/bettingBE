package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.CustomerDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
     private final CustomerService customerService;

    @Override
    public List<AccountDto> getAllAccount() {
        return AccountMapper.INSTANCE.toDtos(accountRepository.findAll());
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        return AccountMapper.INSTANCE.toDto(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        accountRepository.delete(accounts);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(ProjectException::AccountNotFound);
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative", "Enter again");
        }
        account.setTotalBalance(accountDto.getTotalBalance());
        account.setUserName(accountDto.getUserName());
        account.setUserPassword(accountDto.getUserPassword());
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto, Long customerId) {
        CustomerDto customerDto=customerService.getCustomerById(customerId);
        Customer customer=CustomerMapper.INSTANCE.toEntity(customerDto);
        Account account = new Account();
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative", "Enter again");
        }
        account.setTotalBalance(accountDto.getTotalBalance());
        account.setUserName(accountDto.getUserName());
        account.setUserPassword(accountDto.getUserPassword());
        account.setCustomer(customer);

        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.toDto(account);
    }
}
