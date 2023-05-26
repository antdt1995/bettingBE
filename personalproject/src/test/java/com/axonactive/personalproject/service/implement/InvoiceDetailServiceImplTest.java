package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Transactional
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
    void findHouseByInvoiceid() {
        Long id= (long) 15;
        House h=invoiceDetailService.findHouseByInvoiceid(id);
        System.out.println(h);
    }
}