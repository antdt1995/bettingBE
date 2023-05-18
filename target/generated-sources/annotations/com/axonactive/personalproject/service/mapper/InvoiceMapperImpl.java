package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.service.customDto.InvoiceCustomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class InvoiceMapperImpl implements InvoiceMapper {

    @Override
    public InvoiceCustomDto toDto(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }

        InvoiceCustomDto invoiceCustomDto = new InvoiceCustomDto();

        invoiceCustomDto.setAccountId( invoiceAccountId( invoice ) );
        invoiceCustomDto.setId( invoice.getId() );
        invoiceCustomDto.setBetDate( invoice.getBetDate() );

        return invoiceCustomDto;
    }

    @Override
    public List<InvoiceCustomDto> toDtos(List<Invoice> invoices) {
        if ( invoices == null ) {
            return null;
        }

        List<InvoiceCustomDto> list = new ArrayList<InvoiceCustomDto>( invoices.size() );
        for ( Invoice invoice : invoices ) {
            list.add( toDto( invoice ) );
        }

        return list;
    }

    private Long invoiceAccountId(Invoice invoice) {
        if ( invoice == null ) {
            return null;
        }
        Account account = invoice.getAccount();
        if ( account == null ) {
            return null;
        }
        Long id = account.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
