package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.dto.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtos(List<Customer>customers);
}
