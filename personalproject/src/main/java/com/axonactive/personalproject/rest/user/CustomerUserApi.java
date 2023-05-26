package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/bet/user/customers/user")
@PreAuthorize("hasAnyRole('USER', 'ADMIN')")

public interface CustomerUserApi {
    @GetMapping("/{id}")
    ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id);
    @PutMapping("/{customerId}")
    ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId);
}
