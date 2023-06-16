package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Transaction;
import com.axonactive.personalproject.service.dto.TransactionDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "account.id", target = "accountId")
    @Mapping(source = "customer.bankAccount", target = "bankAccount")
    @Mapping(source = "customer.bankName", target = "bankName")
    @Mapping(source = "customer.lastName", target = "customerName")
    @Mapping(source = "account.userName", target = "userName")
    @Mapping(source = "transaction.type", target = "type")
    TransactionDto toDto(Transaction transaction);

    List<TransactionDto> toDtos(List<Transaction> transactions);

}
