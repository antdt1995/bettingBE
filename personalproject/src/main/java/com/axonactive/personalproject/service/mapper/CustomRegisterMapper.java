package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Customer;
import com.axonactive.personalproject.service.customDto.CustomRegisterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomRegisterMapper {
    CustomRegisterMapper INSTANCE= Mappers.getMapper(CustomRegisterMapper.class);
    @Mapping(source = "account.id", target = "id")
    @Mapping(source = "account.userName", target = "userName")
    @Mapping(source = "account.userPassword", target = "userPassword")
    @Mapping(source = "account.totalBalance", target = "totalBalance")
    @Mapping(source = "account.email", target = "email")
    @Mapping(source = "customer.lastName", target = "lastName")
    @Mapping(source = "customer.firstName", target = "firstName")
    @Mapping(source = "customer.phone", target = "phone")
    CustomRegisterDto toDto(Account account, Customer customer);

}
