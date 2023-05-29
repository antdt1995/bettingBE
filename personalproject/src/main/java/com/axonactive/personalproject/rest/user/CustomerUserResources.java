package com.axonactive.personalproject.rest.user;

import com.axonactive.personalproject.rest.user.api.CustomerUserApi;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j

public class CustomerUserResources implements CustomerUserApi {
    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerDto> getCustomerById( Long id) {
        CustomerDto customerDto = customerService.getCustomerById(id);
        return ResponseEntity.ok().body(customerDto);
    }

    @Override
    public ResponseEntity<CustomerDto> updateCustomer(CustomerDto customerDto,Long customerId) {
        log.debug("--> Request update customer by id");
        CustomerDto customer = customerService.updateCustomer(customerDto, customerId);
        return ResponseEntity.ok(customer);
    }
}
