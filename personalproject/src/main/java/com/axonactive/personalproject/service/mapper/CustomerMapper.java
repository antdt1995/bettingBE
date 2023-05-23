package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.dto.CustomerDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper {
    CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    CustomerDto toDto(Customer customer);
    List<CustomerDto> toDtos(List<Customer>customers);
    Customer toEntity(CustomerDto customerDto);
    List<Customer> toEntities(List<CustomerDto>customerDtos);
}
