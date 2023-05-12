package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.BillingDetail;
import com.axonactive.personalproject.service.customDto.BillingDetailCustomDto;
import com.axonactive.personalproject.service.dto.BillingDetailDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BillingDetailMapper {
    BillingDetailMapper INSTANCE = Mappers.getMapper(BillingDetailMapper.class);

    @Mapping(source = "odd.id", target = "oddId")
    @Mapping(source = "billing.id", target = "billId")
    BillingDetailCustomDto toDto(BillingDetail billingDetail);

    List<BillingDetailCustomDto> toDtos(List<BillingDetail> billingDetails);
}
