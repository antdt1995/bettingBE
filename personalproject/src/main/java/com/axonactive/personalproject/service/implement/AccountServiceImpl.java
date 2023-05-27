package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.entity.Role;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.AccountRoleAssignmentRepository;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.CustomRegisterMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.*;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountRoleAssignmentRepository assignRepository;
    private final InvoiceDetailService invoiceDetailService;
    @Autowired
    PasswordEncoder encoder;

    @Override
    public List<AccountDto> getAllAccount() {
        List<Account> accounts = accountRepository.findAll();
        if (accounts.isEmpty()) {
            throw ProjectException.AccountNotFound();
        }
        return AccountMapper.INSTANCE.toDtos(accounts);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id is invalid, please try another Id");
        }
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        return AccountMapper.INSTANCE.toDto(accounts);
    }

    @Override
    public void deleteAccount(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id is invalid, please try another Id");
        }
        Account accounts = accountRepository.findById(id).orElseThrow(ProjectException::AccountNotFound);
        accountRepository.delete(accounts);

    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(ProjectException::AccountNotFound);

        //throw exceptions
        exceptionDto(accountDto);

        //Update information
        account.setTotalBalance(accountDto.getTotalBalance());
        account.setUserName(accountDto.getUserName());
        account.setUserPassword(accountDto.getUserPassword());
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.toDto(account);
    }

    @Override
    public CustomRegisterDto createAccount(CustomRegisterDto customRegisterDto) {

        // build customer
        Customer customer = getCustomer(customRegisterDto);
        customer = customerRepository.save(customer);

        //Throw exceptions
        exception(customRegisterDto);
        Boolean active = true;

        //Build account
        Account account = Account.builder()
                .userName(customRegisterDto.getUserName())
                .totalBalance(customRegisterDto.getTotalBalance())
                .customer(customer)
                .email(customRegisterDto.getEmail())
                .userPassword(encoder.encode(customRegisterDto.getUserPassword()))
                .active(active)
                .build();
        accountRepository.save(account);

        //build role assignment
        AccountRoleAssignment assignment = new AccountRoleAssignment();
        assignment.setRole(Role.ROLE_USER);
        assignment.setAccount(account);
        assignRepository.save(assignment);

        return CustomRegisterMapper.INSTANCE.toDto(account, customer);
    }

    @Override
    public List<Object[]> accountWithMaxBet(Long input) {
        return accountRepository.accountWithMaxBet(input);
    }

    @Override
    public List<Object[]> accountWithCountBet(Long input) {
        return accountRepository.accountWithCountBet(input);
    }

    private static Customer getCustomer(CustomRegisterDto customRegisterDto) {
        if (!isAlpha(customRegisterDto.getFirstName()) || !isAlpha(customRegisterDto.getLastName())) {
            throw ProjectException.badRequest("WrongFormatName", "Name should contain only letters");
        }
        if (!isNumberOnly(customRegisterDto.getPhone())) {
            throw ProjectException.badRequest("WrongFormatPhone", "Phone number should contain only number");
        }
        Customer customer = new Customer();
        customer.setLastName(customRegisterDto.getLastName());
        customer.setFirstName(customRegisterDto.getFirstName());
        customer.setPhone(customRegisterDto.getPhone());
        return customer;
    }

    private void exceptionDto(AccountDto accountDto) {
        if (accountDto.getTotalBalance() < 0) {
            throw ProjectException.badRequest("WrongValue", "Balance cannot equal or less than 0");
        }
        if (!isNumeric(accountDto.getTotalBalance())) {
            throw ProjectException.badRequest("WrongFormatType", "Balance should contain only numbers");
        }
        if (!isAlphanumeric(accountDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(accountDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongPasswordFormat", "Password should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (accountRepository.existsByUserName(accountDto.getUserName())) {
            throw ProjectException.badRequest("UserNameExisted", "User name is already taken");
        }
        if (accountRepository.existsByEmail(accountDto.getEmail())) {
            throw ProjectException.badRequest("EmailExisted", "Email has been used, try different email");
        }
    }

    private void exception(CustomRegisterDto customRegisterDto) {
        if (customRegisterDto.getTotalBalance() <= 0) {
            throw ProjectException.badRequest("WrongValue", "Balance cannot equal or less than 0");
        }
        if (!isNumeric(customRegisterDto.getTotalBalance())) {
            throw ProjectException.badRequest("WrongFormatType", "Balance should contain only numbers");
        }
        if (!isAlphanumeric(customRegisterDto.getUserName())) {
            throw ProjectException.badRequest("WrongUserFormat", "User should only contain alphabet and number");
        }
        if (!isAlphanumericWithSpecial(customRegisterDto.getUserPassword())) {
            throw ProjectException.badRequest("WrongUserPasswordFormat", "Password should only contain alphabet,number, special character and minimum 6 characters");
        }
        if (accountRepository.existsByUserName(customRegisterDto.getUserName())) {
            throw ProjectException.badRequest("UserNameExisted", "User name is already taken");
        }
        if (accountRepository.existsByEmail(customRegisterDto.getEmail())) {
            throw ProjectException.badRequest("EmailExisted", "Email has been used, try different email");
        }
    }

}
