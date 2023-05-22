package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.CustomerApi;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

public class CustomerResources implements CustomerApi {
    private final CustomerService customerService;
    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        log.info("Get all customer");
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        log.info("Get customer by id ");
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(customerDto);
    }
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        log.info("delete customer by id ");
        customerService.deleteCustomer(id);
        String message = "Customer with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();
    }
    @Override
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        log.info("create customer ");
        CustomerDto customer = customerService.createCustomer(customerDto);

        return ResponseEntity.created(URI.create("project/customers/" + customer.getId())).body(customer);
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId) {
        log.info("update customer by id");
        CustomerDto customer = customerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.ok(customer);
    }
}
