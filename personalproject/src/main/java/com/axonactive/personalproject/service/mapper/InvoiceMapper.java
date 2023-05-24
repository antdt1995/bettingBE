package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {
    InvoiceMapper INSTANCE= Mappers.getMapper(InvoiceMapper.class);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "account.id", target ="accountId" )
    InvoiceDto toDto(Invoice invoice);

    List<InvoiceDto> toDtos(List<Invoice> invoices);
}
