package com.axonactive.personalproject.service.implement;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Invoice;
import com.axonactive.personalproject.exception.ProjectException;
import com.axonactive.personalproject.jwt.JwtUtils;
import com.axonactive.personalproject.repository.AccountRepository;
import com.axonactive.personalproject.repository.InvoiceRepository;
import com.axonactive.personalproject.service.AccountService;
import com.axonactive.personalproject.service.InvoiceDetailService;
import com.axonactive.personalproject.service.InvoiceService;
import com.axonactive.personalproject.service.OddService;
import com.axonactive.personalproject.service.customDto.InvoiceWithInvoiceDetailsDto;
import com.axonactive.personalproject.service.dto.AccountDto;
import com.axonactive.personalproject.service.dto.InvoiceDto;
import com.axonactive.personalproject.service.mapper.AccountMapper;
import com.axonactive.personalproject.service.mapper.InvoiceDetailMapper;
import com.axonactive.personalproject.service.mapper.InvoiceMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class InvoiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final AccountRepository accountRepository;
    private final JwtUtils jwtUtils;


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
    public List<InvoiceWithInvoiceDetailsDto> getInvoiceByUsername(String token) {
        String nameToken = "";

        if (StringUtils.hasText(token) && token.startsWith("Bearer ")) {
            nameToken = token.substring(7);
        }

        List<InvoiceWithInvoiceDetailsDto> invoiceWithInvoiceDetailsDto = new ArrayList<>();
        String username = jwtUtils.getUserNameFromJwtToken(nameToken);
        List<Invoice> invoices = invoiceRepository.findByUsername(username);
        for (Invoice invoice : invoices) {
            InvoiceWithInvoiceDetailsDto dto = InvoiceWithInvoiceDetailsDto.builder()
                    .id(invoice.getId())
                    .accountId(invoice.getAccount().getId())
                    .totalBet(invoice.getTotalBet())
                    .invoiceDetails(InvoiceDetailMapper.INSTANCE.toDtos(invoice.getInvoiceDetails()))
                    .build();
            invoiceWithInvoiceDetailsDto.add(dto);
        }
        return invoiceWithInvoiceDetailsDto;
    }


}
