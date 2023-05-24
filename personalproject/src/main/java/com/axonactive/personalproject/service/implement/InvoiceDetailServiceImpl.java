package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.InvoiceDetailRepository;
import com.axonactive.personalproject.repository.InvoiceRepository;
import com.axonactive.personalproject.repository.OddRepository;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.customDto.InvoiceDetailDto;
import com.axonactive.personalproject.service.mapper.InvoiceDetailMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Override
    public List<InvoiceDetailDto> getAllInvoiceDetail() {
        List<InvoiceDetail>invoiceDetails=invoiceDetailRepository.findAll();
        if(invoiceDetails.isEmpty()){
            throw ProjectException.InvoiceDetailNotFound();
        }
        return InvoiceDetailMapper.INSTANCE.toDtos(invoiceDetails);
    }

    @Override
    public InvoiceDetailDto getInvoiceDetailById(Long id) {
        InvoiceDetail invoiceDetail=invoiceDetailRepository.findById(id).orElseThrow(ProjectException::InvoiceDetailNotFound);
        return InvoiceDetailMapper.INSTANCE.toDto(invoiceDetail);
    }
//TODO
    @Override
    public void deleteInvoiceDetail(Long id) {
        if(id==null){
            throw ProjectException.badRequest("IdInvalid","Id cannot be null");
        }
        InvoiceDetail invoiceDetail=invoiceDetailRepository.findById(id).orElseThrow(ProjectException::InvoiceDetailNotFound);
        Invoice invoice=invoiceDetail.getInvoice();
        Double balance=invoice.getTotalBet()-invoiceDetail.getBetAmount();
        invoice.setTotalBet(balance);
        invoiceRepository.save(invoice);
        invoiceDetailRepository.delete(invoiceDetail);
    }

    //sum bet amount
    @Override
    public Double totalBetAmount(Long invoiceId) {
        return invoiceDetailRepository.totalBetAmount(invoiceId);
    }
    //calculate total bet
    public Double calcTotalBet(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(ProjectException::InvoiceNotFound);
        return totalBetAmount(invoice.getId());
    }
    @Override
    public InvoiceDetailDto createInvoiceDetail(InvoiceDetailDto invoiceDetailDto, Long invoiceId, Long oddId) {
        Invoice invoice=invoiceRepository.findById(invoiceId).orElseThrow(ProjectException::InvoiceNotFound);
        Odd odd=oddRepository.findById(oddId).orElseThrow(ProjectException::OddNotFound);

        if(invoiceDetailDto.getBetAmount()<=0){
            throw ProjectException.badRequest("InvalidValue","Bet cannot negative or equal to 0");
        }
        //build invoice detail
        InvoiceDetail invoiceDetail=new InvoiceDetail();
        invoiceDetail.setBetAmount(invoiceDetailDto.getBetAmount());
        invoiceDetail.setInvoice(invoice);
        invoiceDetail.setOdd(odd);
        invoiceDetailRepository.save(invoiceDetail);

        //save total bet into invoice
        Double totalBet=calcTotalBet(invoiceId);
        invoice.setTotalBet(totalBet);
        invoiceRepository.save(invoice);

        //calc into account
        Account account=invoice.getAccount();
        Double balance=account.getTotalBalance()-invoice.getTotalBet();
        account.setTotalBalance(balance);
        accountRepository.save(account);

        return InvoiceDetailMapper.INSTANCE.toDto(invoiceDetail);

    }
}
