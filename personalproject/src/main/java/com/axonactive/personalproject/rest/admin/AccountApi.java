package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.customDto.AccountWithCountBet;
import com.axonactive.personalproject.service.customDto.AccountWithMaxBet;
import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/bet/admin/accounts")
public interface AccountApi {
    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccount();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id);

    @GetMapping("/maxbet")
    ResponseEntity<List<AccountWithMaxBet>> accountWithMaxBet(@RequestParam int limit, Pageable pageable);

    @GetMapping("/countbet")
    ResponseEntity<List<AccountWithCountBet>> accountWithCountBet(@RequestParam int input, Pageable pageable);
}
