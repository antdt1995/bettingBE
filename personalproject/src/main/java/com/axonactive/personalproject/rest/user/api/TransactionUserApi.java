package com.axonactive.personalproject.rest.user.api;

import com.axonactive.personalproject.service.dto.TransactionDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/bet/user/transactions")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
public interface TransactionUserApi {
    @GetMapping
    ResponseEntity<List<TransactionDto>> findAllByAccount();
    @PostMapping
    ResponseEntity<TransactionDto> createTransaction(@RequestBody TransactionDto transactionDto);
}
