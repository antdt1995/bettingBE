package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts=accountRepository.findAll();
        if(accounts.isEmpty()){
            throw ProjectException.AccountNotFound();
        }
        return AccountMapper.INSTANCE.toDtos(accounts);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account accounts=accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        return AccountMapper.INSTANCE.toDto(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account updateAccount(AccountDto accountDto, Long accountId) {
        Account account= accountRepository.findById(accountId).orElseThrow(ProjectException::AccountNotFound);
        if(accountDto.getTotalBalance()<0){
            throw ProjectException.badRequest("Balance Cannot Negative","Enter again");
        }
        account.setTotalBalance(accountDto.getTotalBalance());
        account.setUserName(accountDto.getUserName());
        account.setUserPassword(accountDto.getUserPassword());
        return accountRepository.save(account);
    }

    @Override
    public Account createAccount(AccountDto accountDto, Long customerId) {
        Optional<Customer> customer=customerRepository.findById(customerId);
        Account account=new Account();
        if(accountDto.getTotalBalance()<0){
            throw ProjectException.badRequest("Balance Cannot Negative","Enter again");
        }
        account.setTotalBalance(accountDto.getTotalBalance());
        account.setUserName(accountDto.getUserName());
        account.setUserPassword(accountDto.getUserPassword());

        if(customer.isPresent()){
            account.setCustomer(customer.get());
        }
        return accountRepository.save(account);
    }
}
