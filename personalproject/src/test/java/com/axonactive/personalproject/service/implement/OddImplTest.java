package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.OddService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OddImplTest {
@Autowired
private OddImpl odd;



    @Test
    void findOverOddId() {
        Long id= 7L;
        Long od=odd.findOverOddId(id);
        System.out.println(od);
    }

    @Test
    void findUnderOddId() {
        Long id= 7L;
        Long od=odd.findUnderOddId(id);
        System.out.println(od);
    }
}