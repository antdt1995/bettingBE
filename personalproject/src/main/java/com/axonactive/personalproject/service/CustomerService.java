package com.axonactive.personalproject.service;

import com.axonactive.personalproject.service.dto.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(Long id);
}
