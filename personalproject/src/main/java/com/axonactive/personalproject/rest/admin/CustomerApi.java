package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/customers")
public interface CustomerApi {
    @GetMapping
    ResponseEntity<List<CustomerDto>> getAllCustomer();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id);

}
