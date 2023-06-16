package com.axonactive.personalproject.rest.admin.api;

import com.axonactive.personalproject.service.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/admin/transactions")
@PreAuthorize("hasRole('ADMIN')")
public interface TransactionApi {
    @GetMapping
    ResponseEntity<List<TransactionDto>> getAllTransaction();
    @GetMapping("/{id}")
    ResponseEntity<TransactionDto> findTransactionById(@PathVariable("id") Long id);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteTransactionById(@PathVariable("id")  Long id);

    @PutMapping("/{id}")
    ResponseEntity<TransactionDto> updateTransaction(TransactionDto transactionDto,Long id);
    @PostMapping("/complete/{id}")
    ResponseEntity<Void> completeTransaction(@PathVariable("id") Long id);
}
