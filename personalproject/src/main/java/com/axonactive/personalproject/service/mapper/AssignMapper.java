package com.axonactive.personalproject.service.mapper;
import com.axonactive.personalproject.entity.Assign;
import com.axonactive.personalproject.service.customDto.AssignCustomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AssignMapper {
    AssignMapper INSTANCE= Mappers.getMapper(AssignMapper.class);
    @Mapping(source = "authority.name",target = "roleType")
    @Mapping(source = "customer.lastName", target = "userName")
    AssignCustomDto toDto(Assign assign);
    List<AssignCustomDto> toDtos(List<Assign> assigns);
}