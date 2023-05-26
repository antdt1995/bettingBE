package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.dto.FootballMatchDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
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

    @Test
    void getAllMatchWithTotalBetBetweenDate() {
        LocalDate date1= LocalDate.parse("2023-02-02");
        LocalDate date2=LocalDate.parse("2023-08-02");
        List<Object[]> i=footBallMatchService.getAllMatchWithTotalBetBetweenDate(date1,date2);
        i.forEach(out::println);
    }
}