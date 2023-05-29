package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.AccountRoleAssignmentRepository;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class AccountServiceImplTest {
    @Mock
private CustomerRepository customerRepository;

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountRoleAssignmentRepository assignRepository;

    private AccountService accountService;


}