package com.axonactive.personalproject.service.mapper;

import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.service.customDto.InvoiceDetailCustomDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T10:42:22+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
public class InvoiceDetailMapperImpl implements InvoiceDetailMapper {

    @Override
    public InvoiceDetailCustomDto toDto(InvoiceDetail invoiceDetail) {
        if ( invoiceDetail == null ) {
            return null;
        }

        InvoiceDetailCustomDto invoiceDetailCustomDto = new InvoiceDetailCustomDto();

        invoiceDetailCustomDto.setOddId( invoiceDetailOddId( invoiceDetail ) );
        invoiceDetailCustomDto.setInvoiceId( invoiceDetailInvoiceId( invoiceDetail ) );
        invoiceDetailCustomDto.setBetAmount( invoiceDetail.getBetAmount() );

        return invoiceDetailCustomDto;
    }

    @Override
    public List<InvoiceDetailCustomDto> toDtos(List<InvoiceDetail> invoiceDetails) {
        if ( invoiceDetails == null ) {
            return null;
        }

        List<InvoiceDetailCustomDto> list = new ArrayList<InvoiceDetailCustomDto>( invoiceDetails.size() );
        for ( InvoiceDetail invoiceDetail : invoiceDetails ) {
            list.add( toDto( invoiceDetail ) );
        }

        return list;
    }

    private Long invoiceDetailOddId(InvoiceDetail invoiceDetail) {
        if ( invoiceDetail == null ) {
            return null;
        }
        Odd odd = invoiceDetail.getOdd();
        if ( odd == null ) {
            return null;
        }
        Long id = odd.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long invoiceDetailInvoiceId(InvoiceDetail invoiceDetail) {
        if ( invoiceDetail == null ) {
            return null;
        }
        Invoice invoice = invoiceDetail.getInvoice();
        if ( invoice == null ) {
            return null;
        }
        Long id = invoice.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
