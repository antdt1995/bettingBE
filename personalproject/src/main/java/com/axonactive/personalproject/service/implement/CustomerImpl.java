package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.CustomerRepository;
import com.axonactive.personalproject.service.CustomerService;
import com.axonactive.personalproject.service.dto.CustomerDto;
import com.axonactive.personalproject.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer=customerRepository.findById(id).orElseThrow(ProjectException::CustomerNotFound);
        return CustomerMapper.INSTANCE.toDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomer() {
        return CustomerMapper.INSTANCE.toDtos(customerRepository.findAll());
    }

    @Override
    public void deleteCustomer(Long id) {
        Customer customer=customerRepository.findById(id).orElseThrow(ProjectException::CustomerNotFound);
        customerRepository.delete(customer);
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setFirstName(customerDto.getFirstName());
        customer.setFirstName(customerDto.getLastName());
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto, Long customerId) {
        Customer customer=customerRepository.findById(customerId).orElseThrow(ProjectException::CustomerNotFound);
        customer.setLastName(customerDto.getLastName());
        customer.setFirstName(customerDto.getFirstName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        return customerRepository.save(customer);
    }
}
