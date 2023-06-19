package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.*;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.*;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import com.axonactive.personalproject.service.mapper.InvoiceDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    private final InvoiceDetailRepository invoiceDetailRepository;
    private final InvoiceRepository invoiceRepository;
    private final AccountRepository accountRepository;
    private final OddRepository oddRepository;
    private final HouseRepository houseRepository;
    private final FootballMatchRepository footballMatchRepository;


    @Override
    public List<InvoiceDetailDto> getAllInvoiceDetail() {
        List<InvoiceDetail> invoiceDetails = invoiceDetailRepository.findAll();
        if (invoiceDetails.isEmpty()) {
            throw ProjectException.InvoiceDetailNotFound();
        }
        return InvoiceDetailMapper.INSTANCE.toDtos(invoiceDetails);
    }

    @Override
    public InvoiceDetailDto getInvoiceDetailById(Long id) {
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow(ProjectException::InvoiceDetailNotFound);
        return InvoiceDetailMapper.INSTANCE.toDto(invoiceDetail);
    }

    @Override
    public void deleteInvoiceDetail(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id cannot be null");
        }
        InvoiceDetail invoiceDetail = invoiceDetailRepository.findById(id).orElseThrow(ProjectException::InvoiceDetailNotFound);
        Invoice invoice = invoiceDetail.getInvoice();
        Account account = invoice.getAccount();

        //deduct invoice total bet
        Double bet = invoice.getTotalBet() - invoiceDetail.getBetAmount();
        invoice.setTotalBet(bet);
        invoiceRepository.save(invoice);

        //add into account balance
        Double balance = invoiceDetail.getBetAmount() + account.getTotalBalance();
        account.setTotalBalance(balance);
        accountRepository.save(account);

        //deduct house balance
        House house = findHouseByInvoiceid(invoice.getId());
        house.setBalance(house.getBalance() - invoiceDetail.getBetAmount());
        houseRepository.save(house);

        invoiceDetailRepository.delete(invoiceDetail);
    }

    @Override
    public List<InvoiceDetail> getInvoiceByMatchId(Long matchId) {
        return invoiceDetailRepository.getInvoiceDetailByMatchId(matchId);
    }

    //sum bet amount
    @Override
    public Double totalBetAmount(Long invoiceId) {
        return invoiceDetailRepository.totalBetAmount(invoiceId);
    }

    @Override
    public House findHouseByInvoiceid(Long invoiceId) {
        return invoiceDetailRepository.findHouseByInvoiceid(invoiceId);
    }

    @Override
    public List<IdAndTotalBet> totalBetAmountByMatchId(Long matchId) {
        return invoiceDetailRepository.totalBetAmountByMatchId(matchId);
    }

    public String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }


    @Override
    public List<InvoiceDetailDto> createInvoiceDetail(List<InvoiceDetailDto> invoiceDetailDto) {
        //create new invoice
        Invoice invoice = new Invoice();
        Account account = accountRepository.findByUserName(getCurrentUsername()).orElseThrow(ProjectException::AccountNotFound);
        invoice.setAccount(account);
        invoiceRepository.save(invoice);

        //build invoice detail
        List<InvoiceDetail> invoiceDetailList = new ArrayList<>();
        for (InvoiceDetailDto detailDto : invoiceDetailDto) {
            if (detailDto.getBetAmount() <= 0) {
                throw ProjectException.badRequest("InvalidValue", "Bet cannot negative or equal to 0");
            }
            Odd odd = oddRepository.findById(detailDto.getOddId()).orElseThrow(ProjectException::OddNotFound);
            if (!odd.getActive()) {
                throw ProjectException.badRequest("InvalidValue", "Odd is not active");
            }
            LocalDateTime matchDate = odd.getFootballMatch().getStartDate();
            //make sure bet before match start
            if (odd.getEndDate().isAfter(matchDate)) {
                throw ProjectException.badRequest("InvalidValue", "Match " + odd.getFootballMatch().getHomeTeam() + " vs " + odd.getFootballMatch().getAwayTeam() + " already occured, cannot be bet");
            }

            //create single invoice detail
            InvoiceDetail invoiceDetail = new InvoiceDetail();
            invoiceDetail.setBetAmount(detailDto.getBetAmount());
            invoiceDetail.setInvoice(invoice);
            invoiceDetail.setOdd(odd);
            invoiceDetail.setPaymentStatus(false);
            invoiceDetailRepository.save(invoiceDetail);
            if (invoiceDetail.getBetDate().isAfter(matchDate)) {
                throw ProjectException.badRequest("InvalidValue", "Match " + odd.getFootballMatch().getHomeTeam() + " vs " + odd.getFootballMatch().getAwayTeam() + " already occured, cannot be bet");
            }
            //TODO calculate total bet on Odd for cancel
            invoiceDetailList.add(invoiceDetail);
        }
        invoice.setInvoiceDetails(invoiceDetailList);

        //save total bet into invoice
        Double totalBet = totalBetAmount(invoice.getId());
        invoice.setTotalBet(totalBet);
        invoiceRepository.save(invoice);

        //save into account
        if (invoice.getTotalBet() > account.getTotalBalance()) {
            throw ProjectException.badRequest("InvalidValue", "Balance not enough");
        }
        Double balance = account.getTotalBalance() - invoice.getTotalBet();
        account.setTotalBalance(balance);
        accountRepository.save(account);


        //save into house
        House house = findHouseByInvoiceid(invoice.getId());
        house.setBalance(house.getBalance() + totalBet);
        houseRepository.save(house);

        validateOddStatus(invoiceDetailDto);

        return InvoiceDetailMapper.INSTANCE.toDtos(invoiceDetailList);
    }

    private void validateOddStatus(List<InvoiceDetailDto> invoiceDetailDtos) {
        for (InvoiceDetailDto dto : invoiceDetailDtos) {
            Odd odd = oddRepository.findById(dto.getOddId()).orElseThrow(ProjectException::OddNotFound);
            FootballMatch footballMatch = footballMatchRepository.findById(odd.getFootballMatch().getId()).orElseThrow();
            double highestTotalBet = Collections.max(oddRepository.findTotalBetAmountOfEachOddByMatchID(footballMatch.getId()));
            double lowestTotalBet = Collections.min(oddRepository.findTotalBetAmountOfEachOddByMatchID(footballMatch.getId()));
            if (highestTotalBet / lowestTotalBet > 0.3) {
                odd.setActive(false);
            }
        }
    }
}
