package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Assign;
import com.axonactive.personalproject.service.dto.AssignDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignMapper {
    AssignMapper INSTANCE= Mappers.getMapper(AssignMapper.class);
    @Mapping(source = "roleType.roleName",target = "roleType")
    @Mapping(source = "customer.lastName", target = "userName")
    AssignDto toDto(Assign assign);
    List<AssignDto> toDtos(List<Assign> assigns);
}
