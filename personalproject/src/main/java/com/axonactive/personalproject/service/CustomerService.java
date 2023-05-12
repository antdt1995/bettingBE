package com.axonactive.personalproject.service;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomer();
    CustomerDto getCustomerById(Long id);
    void deleteCustomer(Long id);
    Customer createCustomer(CustomerDto customerDto);
    Customer updateCustomer(CustomerDto customerDto, Long customerId);
}
