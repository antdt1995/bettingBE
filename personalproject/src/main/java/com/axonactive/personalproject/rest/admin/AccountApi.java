package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/bet/accounts")
public interface AccountApi {
    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccount();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id);

    @GetMapping("/maxbet")
    ResponseEntity<List<Object[]>> accountWithMaxBet(@RequestParam Long input);

    @GetMapping("/countbet")
    ResponseEntity<List<Object[]>> accountWithCountBet(@RequestParam Long input);
}
