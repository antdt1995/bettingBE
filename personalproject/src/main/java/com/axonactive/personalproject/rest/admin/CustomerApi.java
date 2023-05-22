package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/auth/customers")
public interface CustomerApi {
    @GetMapping
    ResponseEntity<List<CustomerDto>> getAllCustomer();

    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id);

    @PostMapping
    ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto);

    @PutMapping("/{customerId}")
    ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId);
}
