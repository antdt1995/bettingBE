package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.entity.Role;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.AccountRoleAssignmentRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.CustomerDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumeric;
import static com.axonactive.personalproject.exception.BooleanMethod.isAlphanumericWithSpecial;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final AccountRoleAssignmentRepository assignRepository;
    @Autowired
    PasswordEncoder encoder;

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
        if(id == null){
            throw ProjectException.badRequest("IdInvalid", "Id is invalid, please try another Id");
        }
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        return AccountMapper.INSTANCE.toDto(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        if(id == null){
            throw ProjectException.badRequest("IdInvalid", "Id is invalid, please try another Id");
        }
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        accountRepository.delete(accounts);

    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(ProjectException::AccountNotFound);

        //throw exceptions
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative or 0", "Enter again");
        }
        if(!isNumeric(accountDto.getTotalBalance())){
            throw ProjectException.badRequest("Balance should contain only number", "Enter again");
        }
        if (!isAlphanumeric(accountDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(accountDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongPasswordFormat", "Password should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (accountRepository.existsByUserName(accountDto.getUserName())) {
            throw  ProjectException.badRequest("UserNameExisted", "User name is already taken");
        }
        if (accountRepository.existsByEmail(accountDto.getEmail())) {
            throw  ProjectException.badRequest("EmailExisted", "Email has been used, try different email");
        }

        //Update information
            account.setTotalBalance(accountDto.getTotalBalance());
            account.setUserName(accountDto.getUserName());
            account.setUserPassword(accountDto.getUserPassword());
            account = accountRepository.save(account);
            return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto, Long customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        Customer customer = CustomerMapper.INSTANCE.toEntity(customerDto);

        //Throw exceptions
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("Balance Cannot Negative", "Enter again");
        }
        if (!isAlphanumeric(accountDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(accountDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongUserPasswordFormat", "Password should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (accountRepository.existsByUserName(accountDto.getUserName())) {
            throw  ProjectException.badRequest("UserNameExisted", "User name is already taken");
        }
        if (accountRepository.existsByEmail(accountDto.getEmail())) {
            throw  ProjectException.badRequest("EmailExisted", "Email has been used, try different email");
        }


        //Build
            Account account = Account.builder()
                    .userName(accountDto.getUserName())
                    .totalBalance(accountDto.getTotalBalance())
                    .customer(customer)
                    .email(accountDto.getEmail())
                    .userPassword(encoder.encode(accountDto.getUserPassword()))
                    .build();
        account = accountRepository.save(account);

        AccountRoleAssignment assignment = new AccountRoleAssignment();
        assignment.setRole(Role.ROLE_USER);
        assignment.setAccount(account);
        assignRepository.save(assignment);


            return AccountMapper.INSTANCE.toDto(account);
    }

}
