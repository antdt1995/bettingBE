package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auth/customers/user")
public interface CustomerUserApi {
    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id);
    @PutMapping("/{customerId}")
    ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId);
}
