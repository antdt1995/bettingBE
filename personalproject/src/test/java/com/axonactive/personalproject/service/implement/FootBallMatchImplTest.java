package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.FootBallMatchService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class FootBallMatchImplTest {
@Autowired
private FootBallMatchService footBallMatchService;
    @Test
    void findInvoiceByMatchId() {
        Long id=10L;
        List<Long> i=footBallMatchService.findInvoiceByMatchId(id);
        i.forEach(out::println);
    }
}