package com.axonactive.personalproject.rest;

import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.exception.ResponseException;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static com.axonactive.personalproject.exception.BooleanMethod.isAlpha;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/project/customers")
public class CustomerResources {
    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {
        log.info("Get all customer");
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id) {
        log.info("Get customer by id ");
        if (id == null) {
            throw ProjectException.badRequest("IdIsNull", "Id is null, please enter");
        }
        CustomerDto customerDto = customerService.getCustomerById(id);
        if (customerDto == null) {
            throw ProjectException.CustomerNotFound();
        }
        try {
            return ResponseEntity.ok().body(customerDto);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id) {
        log.info("delete customer by id ");
        if (id == null) {
            throw ProjectException.badRequest("IdIsNull", "Id is null, please enter");
        }
        try {
            customerService.deleteCustomer(id);
            String message = "Customer with ID " + id + " has been successfully deleted.";
            return ResponseEntity.noContent().header("Success", message).build();
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        log.info("create customer ");
        if (!isAlpha(customerDto.getFirstName()) || !isAlpha(customerDto.getLastName())) {
            throw ProjectException.badRequest("WrongFormatName", "Name contain only letters");
        }
        try {
            CustomerDto customer = customerService.createCustomer(customerDto);
            return ResponseEntity.created(URI.create("project/customers/" + customer.getId())).body(customer);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable("customerId") Long customerId) {
        log.info("update customer by id");
        if (!isAlpha(customerDto.getFirstName()) || !isAlpha(customerDto.getLastName())) {
            throw ProjectException.badRequest("WrongFormatName", "Name should contain only letters");
        }
        if (customerId == null) {
            throw ProjectException.badRequest("IdIsNull", "Id is null, please enter");
        }
        CustomerDto customer = customerService.updateCustomer(customerDto, customerId);
        try {
            return ResponseEntity.ok(customer);
        } catch (ResponseException e) {
            throw ProjectException.internalServerError("ErrorHasBeenOccurred", "Error has been occurred. Please try later");
        }
    }
}
