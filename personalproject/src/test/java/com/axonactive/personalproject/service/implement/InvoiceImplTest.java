package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.dto.InvoiceDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class InvoiceImplTest {
@Autowired
private InvoiceImpl invoice;
    @Test
    void createInvoice() {
        InvoiceDto invoiceDto=new InvoiceDto();

        LocalDate betDate= LocalDate.parse("2023-05-05");
        invoiceDto.setBetDate(betDate);
        Long accId= 2L;
        InvoiceDto i=invoice.createInvoice(invoiceDto,accId);
        System.out.println(i);
    }
}