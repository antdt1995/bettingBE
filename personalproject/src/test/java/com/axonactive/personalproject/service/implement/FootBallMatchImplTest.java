package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static java.lang.System.out;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class FootBallMatchImplTest {
@Autowired
private FootBallMatchService footBallMatchService;
    @Test
    void findInvoiceByMatchId() {
        Long id=10L;
        List<Long> i=footBallMatchService.findInvoiceDetailByMatchId(id);
        i.forEach(out::println);
    }

    @Test
    void updateFootballMatch() {
        Long hs=3L;
        Long as=1L;
        Long ts=as+hs;
        Long id=25L;

        FootballMatchDto footballMatchDto=new FootballMatchDto();
        footballMatchDto.setHomeScore(hs);
        footballMatchDto.setAwayScore(as);
        footballMatchDto.setTotalScore(ts);
        footBallMatchService.updateFootballMatch(footballMatchDto,id);

    }

}