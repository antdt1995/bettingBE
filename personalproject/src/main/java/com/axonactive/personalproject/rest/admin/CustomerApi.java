package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.service.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/bet/admin/customers")
@PreAuthorize("hasRole('ADMIN')")
public interface CustomerApi {
    @GetMapping
    ResponseEntity<List<CustomerDto>> getAllCustomer();

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id);

}
