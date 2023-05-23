package com.axonactive.personalproject.service.mapper;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.service.customDto.AccountRoleAssignCustomDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignMapper {
    AssignMapper INSTANCE= Mappers.getMapper(AssignMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "account.userName", target = "userName")
    @Mapping(source = "accountRoleAssignment.role", target = "role")
    AccountRoleAssignCustomDto toDto(AccountRoleAssignment accountRoleAssignment);

    List<AccountRoleAssignCustomDto> toDtos(List<AccountRoleAssignment> accountRoleAssignments);
}