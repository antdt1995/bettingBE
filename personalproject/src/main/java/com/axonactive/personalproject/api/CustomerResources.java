package com.axonactive.personalproject.api;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.exception.ResponseException;
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
@RequestMapping("/project/customers")
public class CustomerResources {
    private final CustomerService customerService;
    @GetMapping
    public ResponseEntity<List<CustomerDto>>getAllCustomer(){
        log.info("Get all customer");
            return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long id){
        log.info("Get customer by id {}",id);
        try {
            return ResponseEntity.ok().body(customerService.getCustomerById(id));
        }catch (ResponseException e){
            log.error("an error occur by id: {}",id+" "+e.getMessage());
            throw e;
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        log.info("delete customer by id {}", id);
        try {
            customerService.deleteCustomer(id);
            return ResponseEntity.noContent().build();
        }catch (ResponseException e){
            log.error("an error occur by id: {}",id+" "+e.getMessage());
            throw e;
        }
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        log.info("create customer {}");
        try {
            CustomerDto customer=customerService.createCustomer(customerDto);
            return ResponseEntity.created(URI.create("project/customers/"+customer.getId())).body(customer);
        }catch (ResponseException e){
            log.error("an error occur: {}",e.getMessage());
            throw e;
        }
    }
    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerDto> updateCustomer (@RequestBody CustomerDto customerDto,@PathVariable("customerId") Long customerId){
        log.info("update customer by id {}", customerId);
        try {
            CustomerDto customer=customerService.updateCustomer(customerDto,customerId);
            return ResponseEntity.ok(customer);
        }catch (ResponseException e) {
            log.error("an error occur: {}", e.getMessage());
            throw e;
        }
    }
}
