package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class InvoiceDetailServiceImplTest {
@Autowired
private InvoiceDetailServiceImpl invoiceDetailService;
    @Test
    void totalBetAmount() {
        Long id= (long) 15;
        Double invoiceDetailDto=invoiceDetailService.totalBetAmount(id);
        System.out.println(invoiceDetailDto);
    }

    @Test
    void calcTotalBet() {
        Long id= (long) 15;
        Double a=invoiceDetailService.calcTotalBet(id);
        System.out.println(a);
    }
}