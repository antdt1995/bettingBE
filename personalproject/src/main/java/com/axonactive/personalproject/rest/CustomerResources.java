package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.rest.admin.CustomerApi;
import com.axonactive.personalproject.rest.user.CustomerUserApi;
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

public class CustomerResources implements CustomerApi, CustomerUserApi {
    private final CustomerService customerService;
    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        log.info("Get all customer");
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @Override
    public ResponseEntity<CustomerDto> getCustomerById( Long id) {
        log.info("Get customer by id ");
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(customerDto);
    }
    @Override
    public ResponseEntity<Void> deleteCustomerById( Long id) {
        log.info("delete customer by id ");
        customerService.deleteCustomer(id);
        String message = "Customer with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto,Long customerId) {
        log.info("update customer by id");
        CustomerDto customer = customerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.ok(customer);
    }
}
