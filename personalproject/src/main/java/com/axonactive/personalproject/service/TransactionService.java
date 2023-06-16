package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    List<TransactionDto> getAllTransaction();
    TransactionDto findTransactionById(Long id);
    void deleteTransactionById(Long id);
    TransactionDto createTransaction(TransactionDto transactionDto);
    TransactionDto updateTransaction(TransactionDto transactionDto,Long id);
    List<TransactionDto> findAllByAccount();
    void completeTransaction(Long id);
}
