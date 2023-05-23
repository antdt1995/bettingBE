package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.AccountDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/accounts")
public interface AccountApi {
    @GetMapping
    ResponseEntity<List<AccountDto>> getAllAccount();



    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteAccount(@PathVariable("id") Long id);



}
