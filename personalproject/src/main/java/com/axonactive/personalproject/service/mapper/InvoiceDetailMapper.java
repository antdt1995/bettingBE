package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceDetailMapper {
    InvoiceDetailMapper INSTANCE = Mappers.getMapper(InvoiceDetailMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "odd.id", target = "oddId")
    @Mapping(source = "invoice.id", target = "invoiceId")
    InvoiceDetailDto toDto(InvoiceDetail invoiceDetail);

    List<InvoiceDetailDto> toDtos(List<InvoiceDetail> invoiceDetails);
}
