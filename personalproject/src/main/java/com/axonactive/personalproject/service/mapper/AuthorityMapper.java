package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Authority;
import com.axonactive.personalproject.service.dto.AuthorityDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper {
    AuthorityMapper INSTANCE= Mappers.getMapper(AuthorityMapper.class);
    AuthorityDto toDto(Authority authority);
    List<AuthorityDto> toDtos(List<Authority> authorities);
}
