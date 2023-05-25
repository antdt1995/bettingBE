package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.InvoiceRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InvoiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final AccountRepository accountRepository;



    @Override
    public List<InvoiceDto> getAllInvoice() {
        List<Invoice> invoices = invoiceRepository.findAll();
        if (invoices.isEmpty()) {
            throw ProjectException.InvoiceNotFound();
        }
        return InvoiceMapper.INSTANCE.toDtos(invoices);
    }

    @Override
    public InvoiceDto getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(ProjectException::InvoiceNotFound);
        return InvoiceMapper.INSTANCE.toDto(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        if (id == null) {
            throw ProjectException.badRequest("IdInvalid", "Id cannot be null");
        }
        Invoice invoice = invoiceRepository.findById(id).orElseThrow(ProjectException::InvoiceNotFound);
        Account account = invoice.getAccount();
        Double balance = account.getTotalBalance() + invoice.getTotalBet();
        account.setTotalBalance(balance);
        accountRepository.save(account);
        invoiceRepository.delete(invoice);
    }

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoiceDto, Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(ProjectException::AccountNotFound);


        //build invoice
        Invoice invoice = new Invoice();
        invoice.setAccount(account);
        invoice.setBetDate(invoiceDto.getBetDate());
        invoice = invoiceRepository.save(invoice);


//        Double totalBet= invoiceDetailService.totalBetAmount(invoice.getId());
//        invoice.setTotalBet(totalBet);
//        invoice = invoiceRepository.save(invoice);
//
//        Double balance=account.getTotalBalance()-invoice.getTotalBet();
//        account.setTotalBalance(balance);
//        accountRepository.save(account);

        return InvoiceMapper.INSTANCE.toDto(invoice);

    }


}
