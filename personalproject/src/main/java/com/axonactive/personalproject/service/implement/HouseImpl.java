package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.*;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.FootballMatchRepository;
import com.axonactive.personalproject.repository.HouseRepository;
import com.axonactive.personalproject.repository.InvoiceRepository;
import com.axonactive.personalproject.service.FootBallMatchService;
import com.axonactive.personalproject.service.HouseService;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.dto.HouseDto;
import com.axonactive.personalproject.service.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static com.axonactive.personalproject.exception.BooleanMethod.*;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final OddService oddService;
    private final InvoiceRepository invoiceRepository;
    private final FootballMatchRepository footballMatchRepository;
    private final AccountRepository accountRepository;
    private final Double HOUSE_WIN = 0.02;
    @Override
    public List<HouseDto> getAllHouse() {
        List<House> houses=houseRepository.findAll();
        if(houses.isEmpty()){
            throw ProjectException.houseNotFound();
        }
        return HouseMapper.INSTANCE.toDtos(houses);
    }

    @Override
    public HouseDto findHouseById(Long id) {
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);

        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public void deleteHouseById(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        houseRepository.delete(house);
    }

    @Override
    public HouseDto createHouse(HouseDto houseDto) {
        exception(houseDto);
        House house=new House();
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }
    @Override
    public HouseDto updateHouse(HouseDto houseDto, Long id) {
        exception(houseDto);
        House house=houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }

    public Long findOverUnderOdd(Long matchId) {

        // get football match
        FootballMatch footballMatch = footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);
        // get total score
        Long totalScore = footballMatch.getTotalScore();
        // get odds based on football match
        List<Odd> odd = footballMatch.getOdds();
        // compare set score of odd to total score of football match

        for (Odd os : odd) {
            Long overId = oddService.findOverOddId(matchId);

            Long underId = oddService.findUnderOddId(matchId);

            Double setScore = os.getSetScore();

            Long oddId = os.getId();

            //check possibility win of odd id under/over with fix set score
            if (setScore == 0.5 || setScore == 1.5 || setScore == 2.5 || setScore == 3.5) {
                if (totalScore < setScore) {
                    oddId = underId;
                } else {
                    oddId = overId;
                }
            }
            if (setScore == 1 || setScore == 2 || setScore == 3) {
                if (totalScore < setScore) {
                    oddId = underId;
                } else {
                    oddId = overId;
                }
            }
            // Return the odd ID if it meets your criteria
            if (oddId != null) {
                return oddId;
            }
        }
        // Return null or a default value if no matching odd is found
        return null;
    }

    public Double calcWin(Long invoiceId) {
        //get invoice
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(ProjectException::InvoiceNotFound);

        //get invoice detail
        List<InvoiceDetail> invoiceDetails = invoice.getInvoiceDetails();

        //get bet odd
        Double winAmount = 0.0;
        for (InvoiceDetail detail : invoiceDetails) {
            Odd odd = detail.getOdd();

            //get odd id from 2 method
            Long winLoseOddId = oddService.findWinLoseOddIds(odd.getFootballMatch().getId());
            Long winUnderOverOddId = findOverUnderOdd(odd.getFootballMatch().getId());

            //create local fields
            Long betOddId = odd.getId();
            Double oddRate = odd.getOddRate();
            Double bet = detail.getBetAmount();

            if (Objects.equals(winLoseOddId, betOddId) || Objects.equals(winUnderOverOddId, betOddId)) {
                winAmount += bet * oddRate;
            }
        }
        return winAmount;
    }

    public void getInterest(Long invoiceId, Long houseId) {

        //get invoice
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(ProjectException::InvoiceNotFound);
        Double invoiceBet = invoice.getTotalBet();

        //get account bet
        Account account = invoice.getAccount();
        Double balance = account.getTotalBalance();

        //get House
        House house =houseRepository.findById(houseId).orElseThrow(ProjectException::houseNotFound);
        Double houseBalance = house.getBalance();

        // get interest and basic calc
        Double interest = calcWin(invoice.getId());
        if (interest == null) {
            house.setBalance(houseBalance + invoiceBet);
        } else {
            //calc house interest
            Double houseWin = interest * HOUSE_WIN;

            //get final interest
            Double lastInterest = interest - houseWin;

            //calc sum for account
            Double win = balance + lastInterest;

            //calc ,set and save into house
            house.setBalance(houseBalance+houseWin-lastInterest);
            houseRepository.save(house);

            //set and save into account
            account.setTotalBalance(win);
            accountRepository.save(account);

        }
    }

    private static void exception(HouseDto houseDto) {
        if(!isAlphanumeric(houseDto.getName())){
            throw ProjectException.badRequest("WrongFormat","House name should contain only letters and numbers");
        }
        if(!isNumeric(houseDto.getBalance())){
            throw ProjectException.badRequest("WrongFormat","Balance should contain only numbers");
        }
        if(houseDto.getBalance()<=0){
            throw ProjectException.badRequest("WrongValue","Balance cannot equal or less than 0");
        }
    }
}
