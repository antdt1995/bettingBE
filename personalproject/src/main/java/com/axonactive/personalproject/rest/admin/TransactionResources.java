package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.TransactionApi;
import com.axonactive.personalproject.service.TransactionService;
import com.axonactive.personalproject.service.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TransactionResources implements TransactionApi {
    private final TransactionService transactionService;

    @Override
    public ResponseEntity<List<TransactionDto>> getAllTransaction() {
        return ResponseEntity.ok(transactionService.getAllTransaction());
    }

    @Override
    public ResponseEntity<TransactionDto> findTransactionById(Long id) {
        return ResponseEntity.ok(transactionService.findTransactionById(id));
    }

    @Override
    public ResponseEntity<Void> deleteTransactionById(Long id) {
        log.warn("deleteTransactionById");
        transactionService.deleteTransactionById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> completeTransaction(Long id) {

        transactionService.completeTransaction(id);
        return ResponseEntity.accepted().build();
    }

    @Override
    public ResponseEntity<TransactionDto> updateTransaction(TransactionDto transactionDto, Long id) {
        log.warn("updateTransaction");
        return ResponseEntity.ok(transactionService.updateTransaction(transactionDto, id));
    }
}
