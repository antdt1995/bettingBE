package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.dto.CustomerDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        customerDto.setLastName( customer.getLastName() );
        customerDto.setFirstName( customer.getFirstName() );
        customerDto.setEmail( customer.getEmail() );
        customerDto.setPhone( customer.getPhone() );

        return customerDto;
    }

    @Override
    public List<CustomerDto> toDtos(List<Customer> customers) {
        if ( customers == null ) {
            return null;
        }

        List<CustomerDto> list = new ArrayList<CustomerDto>( customers.size() );
        for ( Customer customer : customers ) {
            list.add( toDto( customer ) );
        }

        return list;
    }

    @Override
    public Customer toEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setLastName( customerDto.getLastName() );
        customer.setFirstName( customerDto.getFirstName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setPhone( customerDto.getPhone() );

        return customer;
    }

    @Override
    public List<Customer> toEntities(List<CustomerDto> customerDtos) {
        if ( customerDtos == null ) {
            return null;
        }

        List<Customer> list = new ArrayList<Customer>( customerDtos.size() );
        for ( CustomerDto customerDto : customerDtos ) {
            list.add( toEntity( customerDto ) );
        }

        return list;
    }
}
