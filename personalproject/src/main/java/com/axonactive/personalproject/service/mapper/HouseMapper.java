package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.service.dto.HouseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HouseMapper {
    HouseMapper INSTANCE= Mappers.getMapper(HouseMapper.class);
    HouseDto toDto(House house);
    List<HouseDto>toDtos(List<House>houses);
}
