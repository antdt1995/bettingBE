package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.service.customDto.InvoiceCustomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceMapper {
    InvoiceMapper INSTANCE= Mappers.getMapper(InvoiceMapper.class);

    @Mapping(source = "account.id", target ="accountId" )
    InvoiceCustomDto toDto(Invoice invoice);

    List<InvoiceCustomDto> toDtos(List<Invoice> invoices);
}
