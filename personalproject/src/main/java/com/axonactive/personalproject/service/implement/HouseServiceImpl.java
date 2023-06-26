package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.*;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.*;
import com.axonactive.personalproject.service.*;
import com.axonactive.personalproject.service.customDto.AccountAndMaxWinInYear;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.dto.HouseDto;
import com.axonactive.personalproject.service.mapper.HouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.axonactive.personalproject.exception.BooleanMethod.*;
import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class HouseServiceImpl implements HouseService {
    private final HouseRepository houseRepository;
    private final OddService oddService;
    private final InvoiceRepository invoiceRepository;
    private final FootballMatchRepository footballMatchRepository;
    private final AccountRepository accountRepository;
    private final InvoiceDetailService invoiceDetailService;
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final Double HOUSE_WIN = 0.02;

    private static Long getWinUnderOverId(Long totalScore, Long overId, Long underId, Double setScore, Long oddId) {
        if (setScore == 0.5 || setScore == 1.5 || setScore == 2.5 || setScore == 3.5 || setScore == 1 || setScore == 2 || setScore == 3) {
            if (totalScore < setScore) {
                oddId = underId;
            } else {
                oddId = overId;
            }
        }
        if (setScore > 3.5) {
            oddId = null;
        }
        return oddId;
    }

    private static void exception(HouseDto houseDto) {
        if (!isAlphanumeric(houseDto.getName())) {
            throw ProjectException.badRequest("WrongFormat", "House name should contain only letters and numbers");
        }
        if (!isNumeric(houseDto.getBalance())) {
            throw ProjectException.badRequest("WrongFormat", "Balance should contain only numbers");
        }
        if (houseDto.getBalance() <= 0) {
            throw ProjectException.badRequest("WrongValue", "Balance cannot equal or less than 0");
        }
    }

    @Override
    public List<HouseDto> getAllHouse() {
        List<House> houses = houseRepository.findAll();
        if (houses.isEmpty()) {
            throw ProjectException.houseNotFound();
        }
        return HouseMapper.INSTANCE.toDtos(houses);
    }

    @Override
    public HouseDto findHouseById(Long id) {
        House house = houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);

        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public void deleteHouseById(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id cannot be null");
        }
        House house = houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        houseRepository.delete(house);
    }

    @Override
    public HouseDto createHouse(HouseDto houseDto) {
        exception(houseDto);
        House house = new House();
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public HouseDto updateHouse(HouseDto houseDto, Long id) {
        exception(houseDto);
        House house = houseRepository.findById(id).orElseThrow(ProjectException::houseNotFound);
        house.setName(houseDto.getName());
        house.setAddress(houseDto.getAddress());
        house.setBalance(houseDto.getBalance());
        houseRepository.save(house);
        return HouseMapper.INSTANCE.toDto(house);
    }

    @Override
    public Long findWinOverUnderOddId(Long matchId) {

        // get football match
        FootballMatch footballMatch = footballMatchRepository.findById(matchId)
                .orElseThrow(ProjectException::footballMatchNotFound);

        // get total score
        Long totalScore = footballMatch.getTotalScore();

        // get odds based on football match
        List<Odd> odd = footballMatch.getOdds();

        // compare set score of odd to total score of football match
        Long overId = oddService.findOverOddId(matchId);
        Long underId = oddService.findUnderOddId(matchId);
        for (Odd os : odd) {

            Double setScore = os.getSetScore();

            Long oddId = os.getId();

            // check possibility win of odd id under/over with fix set score
            oddId = getWinUnderOverId(totalScore, overId, underId, setScore, oddId);

            // return the odd ID if it meets your criteria
            if (oddId != null) {
                return oddId;
            }
        }
        // Return null or a default value if no matching odd is found
        return null;
    }

    @Override
    public Double calcWinAmount(Long invoiceDetailId) {

        // Get the invoice details
        InvoiceDetail invoiceDetails = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(ProjectException::InvoiceDetailNotFound);

        // Calculate the win amount
        Double winAmount = 0.0;
        Odd odd = invoiceDetails.getOdd();

        // Get the win odd IDs for the football match
        Long winLoseOddId = oddService.findWinOddIds(odd.getFootballMatch().getId());
        Long winUnderOverOddId = findWinOverUnderOddId(odd.getFootballMatch().getId());

        // Check if the bet odd ID matches the win odd IDs
        Long betOddId = odd.getId();
        Double oddRate = odd.getOddRate();
        Double bet = invoiceDetails.getBetAmount();

        if (Objects.equals(winLoseOddId, betOddId) || Objects.equals(winUnderOverOddId, betOddId)) {
            winAmount = bet * oddRate;
        }

        return winAmount;
    }

    @Override
    public void paidInterest(Long invoiceDetailId) {

        //get invoice detail
        InvoiceDetail invoiceDetails = invoiceDetailRepository.findById(invoiceDetailId).orElseThrow(ProjectException::InvoiceDetailNotFound);

        //get account bet
        Account account = invoiceDetails.getInvoice().getAccount();
        Double balance = account.getTotalBalance();

        //get House
        House house = invoiceDetails.getOdd().getHouse();
        Double houseBalance = house.getBalance();

        // get interest and basic calc
        Double interest = calcWinAmount(invoiceDetails.getId());

        if (invoiceDetails.getPaymentStatus()){
            throw ProjectException.badRequest("PaymentStatus", "Payment status cannot be changed");
        }

        if (interest != null) {
            //calc house interest
            Double houseWin = interest * HOUSE_WIN;

            //get final interest
            Double lastInterest = interest - houseWin;

            //calc ,set and save into house
            house.setBalance(houseBalance + houseWin - lastInterest);
            houseRepository.save(house);

            //set and save into account
            account.setTotalBalance(balance + lastInterest);
            accountRepository.save(account);

            //set status complete transaction
            invoiceDetails.setPaymentStatus(true);
            invoiceDetailRepository.save(invoiceDetails);
        }
    }

    @Override
    public void completePayment(Long matchId) {
        FootballMatch footballMatch = footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);
        if (footballMatch.getCompleteStatus()) {
            List<Long> invoiceDetailId = footballMatchRepository.findInvoiceDetailByMatchId(footballMatch.getId());
            for (Long invoiceIdDetail : invoiceDetailId) {
                calcWinAmount(invoiceIdDetail);
                paidInterest(invoiceIdDetail);
            }
        }
    }

    @Override
    public List<IdAndTotalBet> findWinAccountByMatchId(Long matchId) {
        List<IdAndTotalBet> idAndTotalBets = new ArrayList<>();

        FootballMatch footballMatch = footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);

        Long overUnderOddId = findWinOverUnderOddId(footballMatch.getId());
        Long oddWinId = oddService.findWinOddIds(footballMatch.getId());
        List<InvoiceDetail> invoiceDetails = invoiceDetailService.getInvoiceByMatchId(footballMatch.getId());

        Double winAmount = 0.0;

        for (InvoiceDetail detail : invoiceDetails) {
            IdAndTotalBet idAndTotalBet = new IdAndTotalBet();
            Long oddId = detail.getOdd().getId();
            Long accId = detail.getInvoice().getAccount().getId();
            Double oddRate = detail.getOdd().getOddRate();
            Double bet = detail.getBetAmount();
            if (Objects.equals(oddId, overUnderOddId) || Objects.equals(oddId, oddWinId)) {
                idAndTotalBet.setId(accId);
                idAndTotalBet.setBet((bet * oddRate) -bet);
            }
            idAndTotalBets.add(idAndTotalBet);

        }
        return idAndTotalBets;
    }

    @Override
    public List<IdAndTotalBet> findLoseAccountByMatchId(Long matchId) {
        List<IdAndTotalBet> idAndTotalBets = new ArrayList<>();

        FootballMatch footballMatch = footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);

        Long overUnderOddId = findWinOverUnderOddId(footballMatch.getId());
        Long oddWinId = oddService.findWinOddIds(footballMatch.getId());
        List<InvoiceDetail> invoicesDetail = invoiceDetailService.getInvoiceByMatchId(footballMatch.getId());

        Double loseAmount = 0.0;

        for (InvoiceDetail detail : invoicesDetail) {
            IdAndTotalBet idAndTotalBet = new IdAndTotalBet();
            Long oddId = detail.getOdd().getId();
            Long accId = detail.getInvoice().getAccount().getId();

            if (!Objects.equals(oddId, overUnderOddId) && !Objects.equals(oddId, oddWinId)) {
                idAndTotalBet.setId(accId);
                loseAmount = detail.getBetAmount();
                idAndTotalBet.setBet(loseAmount);
            }
            idAndTotalBets.add(idAndTotalBet);

        }
        return idAndTotalBets;
    }

    @Override
    public List<AccountAndMaxWinInYear> findAccountWinMostMoneyInYear(LocalDate inputYear, Long input, Long matchId) {

        FootballMatch footballMatch = footballMatchRepository.findById(matchId).orElseThrow(ProjectException::footballMatchNotFound);
        List<InvoiceDetail> invoicesDetail = invoiceDetailService.getInvoiceByMatchId(footballMatch.getId());
        List<AccountAndMaxWinInYear> accountAndMaxWinInYears = invoicesDetail.stream()
                .filter(detail -> detail.getBetDate().getYear() == inputYear.getYear())
                .map(detail -> {
                    AccountAndMaxWinInYear accountAndMaxWinInYear = new AccountAndMaxWinInYear();
                    accountAndMaxWinInYear.setAccountId(detail.getInvoice().getAccount().getId());
                    accountAndMaxWinInYear.setMaxWin(calcWinAmount(detail.getInvoice().getId()));
                    return accountAndMaxWinInYear;
                })
                .distinct()
                .sorted(Comparator.comparingDouble(AccountAndMaxWinInYear::getMaxWin).reversed())
                .limit(input)
                .collect(Collectors.toList());
        return accountAndMaxWinInYears;
    }

    @Override
    public List<Double> houseMinimumWin(Long matchID) {
        List<Double> betAmountOfEachOdd = oddService.findTotalBetAmountOfEachOddByMatchID(matchID);
        for(int i = 0; i < betAmountOfEachOdd.size();i++){
            if(betAmountOfEachOdd.get(i) == null){
                betAmountOfEachOdd.set(i, 0.0);
            }
            betAmountOfEachOdd.set(i, betAmountOfEachOdd.get(i) * HOUSE_WIN);
        }
        return betAmountOfEachOdd;
    }
}
