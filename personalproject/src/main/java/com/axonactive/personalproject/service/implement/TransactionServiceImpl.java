package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.entity.Transaction;
import com.axonactive.personalproject.entity.TransactionType;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.repository.TransactionRepository;
import com.axonactive.personalproject.service.TransactionService;
import com.axonactive.personalproject.service.dto.TransactionDto;
import com.axonactive.personalproject.service.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<TransactionDto> getAllTransaction() {
        List<Transaction> transactions=transactionRepository.findAll();
        if(transactions.isEmpty()){
            throw ProjectException.TransactionNotFound();
        }
        return TransactionMapper.INSTANCE.toDtos(transactions);
    }

    @Override
    public TransactionDto findTransactionById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        Transaction transaction=transactionRepository.findById(id).orElseThrow(ProjectException::TransactionNotFound);
        return TransactionMapper.INSTANCE.toDto(transaction);
    }

    @Override
    public void deleteTransactionById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        Transaction transaction=transactionRepository.findById(id).orElseThrow(ProjectException::TransactionNotFound);
        transactionRepository.delete(transaction);
    }
    public String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public List<TransactionDto> findAllByAccount() {
        String username = getCurrentUsername();
        Account currentAccount=accountRepository.findByUserName(username) .orElseThrow(ProjectException::AccountNotFound);
        List<Transaction> transactions = transactionRepository.findAllByAccount(currentAccount);
        return TransactionMapper.INSTANCE.toDtos(transactions);
    }

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {

        String username = getCurrentUsername();
        Account account=accountRepository.findByUserName(username) .orElseThrow(ProjectException::AccountNotFound);
        Customer customer=account.getCustomer();

        if(transactionDto.getAmount()<0){
            throw ProjectException.badRequest("AmountInvalid","Amount cannot be negative");
        }

        Transaction transaction=Transaction.builder()
                .type(TransactionType.valueOf(transactionDto.getType()))
                .amount(transactionDto.getAmount())
                .customer(customer)
                .account(account)
                .complete(false)
                .build();
        transactionRepository.save(transaction);



        return TransactionMapper.INSTANCE.toDto(transaction);
    }

    @Override
    public void completeTransaction(Long id) {
        Transaction transaction=transactionRepository.findById(id).orElseThrow(ProjectException::TransactionNotFound);
        Account account =transaction.getAccount();

        if(transaction.getComplete()){
            throw ProjectException.badRequest("TransactionCompleted","Transaction is completed");
        }
        //withdraw from account
        if (transaction.getType().equals(TransactionType.WITHDRAW)){
            Double remainBalance=account.getTotalBalance()-transaction.getAmount();
            account.setTotalBalance(remainBalance);
            accountRepository.save(account);
        }

        //deposit into account
        if (transaction.getType().equals(TransactionType.DEPOSIT)){
            Double remainBalance=account.getTotalBalance()+transaction.getAmount();
            account.setTotalBalance(remainBalance);
            accountRepository.save(account);
        }
        transaction.setComplete(true);
        transactionRepository.save(transaction);


    }

    @Override
    public TransactionDto updateTransaction(TransactionDto transactionDto, Long id) {
        if(transactionDto.getAmount()<0){
            throw ProjectException.badRequest("AmountInvalid","Amount cannot be negative");
        }
        Transaction transaction=transactionRepository.findById(id).orElseThrow(ProjectException::TransactionNotFound);
        transaction.setType(TransactionType.valueOf(transactionDto.getType()));
        transaction.setAccount(accountRepository.findById(transactionDto.getAccountId()).orElseThrow(ProjectException::AccountNotFound));
        transaction.setCustomer(customerRepository.findById(transactionDto.getCustomerId()).orElseThrow(ProjectException::CustomerNotFound));
        transaction.setAmount(transactionDto.getAmount());
        transactionRepository.save(transaction);
        return TransactionMapper.INSTANCE.toDto(transaction);
    }

}
