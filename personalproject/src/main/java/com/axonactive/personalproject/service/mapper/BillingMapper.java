package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Billing;
import com.axonactive.personalproject.service.dto.BillingDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BillingMapper {
    BillingMapper INSTANCE= Mappers.getMapper(BillingMapper.class);

    @Mapping(source = "account.id", target ="accountId" )
    BillingDto toDto(Billing billing);

    List<BillingDto> toDtos(List<Billing>billings);
}
