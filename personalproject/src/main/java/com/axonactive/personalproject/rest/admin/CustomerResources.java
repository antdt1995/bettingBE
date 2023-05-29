package com.axonactive.personalproject.rest.admin;

import com.axonactive.personalproject.rest.admin.api.CustomerApi;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j

public class CustomerResources implements CustomerApi {
    private final CustomerService customerService;
    @Override
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @Override
    public ResponseEntity<Void> deleteCustomerById( Long id) {
        log.debug("--> Request delete customer by id ");
        customerService.deleteCustomer(id);
        String message = "Customer with ID " + id + " has been successfully deleted.";
        return ResponseEntity.noContent().header("Success", message).build();
    }

}
