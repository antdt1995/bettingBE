package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.service.dto.AccountDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {
    AccountMapper INSTANCE= Mappers.getMapper(AccountMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    AccountDto toDto(Account account);
    List<AccountDto> toDtos(List<Account>accounts);
    Account toEntity(AccountDto accountDto);
    List<Account> toEntities(List<AccountDto>accountDtos);

}
