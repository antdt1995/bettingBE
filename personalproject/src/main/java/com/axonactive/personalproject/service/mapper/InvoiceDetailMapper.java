package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.service.customDto.InvoiceDetailCustomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface InvoiceDetailMapper {
    InvoiceDetailMapper INSTANCE = Mappers.getMapper(InvoiceDetailMapper.class);

    @Mapping(source = "odd.id", target = "oddId")
    @Mapping(source = "invoice.id", target = "invoiceId")
    InvoiceDetailCustomDto toDto(InvoiceDetail invoiceDetail);

    List<InvoiceDetailCustomDto> toDtos(List<InvoiceDetail> invoiceDetails);
}
