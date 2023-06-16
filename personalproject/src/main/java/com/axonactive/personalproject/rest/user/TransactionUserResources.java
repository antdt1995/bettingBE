package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.TransactionUserApi;
import com.axonactive.personalproject.service.TransactionService;
import com.axonactive.personalproject.service.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class TransactionUserResources implements TransactionUserApi {
    private final TransactionService transactionService;

    @Override
    public ResponseEntity<List<TransactionDto>> findAllByAccount() {
        return ResponseEntity.ok(transactionService.findAllByAccount());
    }
    @Override
    public ResponseEntity<TransactionDto> createTransaction(TransactionDto transactionDto) {
        log.warn("createTransaction");
        return ResponseEntity.created(URI.create("/bet/transactions"+transactionDto.getId())).body(transactionService.createTransaction(transactionDto));
    }

}
