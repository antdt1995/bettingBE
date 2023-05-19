package com.axonactive.personalproject.service.mapper;
import com.axonactive.personalproject.entity.AccountRoleAssignment;
import com.axonactive.personalproject.service.customDto.AssignCustomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignMapper {
    AssignMapper INSTANCE= Mappers.getMapper(AssignMapper.class);

    @Mapping(source = "account.userName", target = "userName")
    AssignCustomDto toDto(AccountRoleAssignment accountRoleAssignment);
    List<AssignCustomDto> toDtos(List<AccountRoleAssignment> accountRoleAssignments);
}