package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.House;
import com.axonactive.personalproject.entity.InvoiceDetail;
import com.axonactive.personalproject.service.customDto.IdAndTotalBet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
    @Query("select sum(id.betAmount)from InvoiceDetail id, Invoice i where id.invoice.id = i.id and i.id = :invoiceId")
    Double totalBetAmount(@Param("invoiceId") Long invoiceId);

    @Query("select distinct h from Invoice i, InvoiceDetail id, Odd o, House h where id.odd.id = o.id and o.house.id = h.id and id.invoice.id=i.id and i.id =:invoiceId")
    House findHouseByInvoiceid(Long invoiceId);

    @Query("select id.id, sum(id.betAmount)from InvoiceDetail id, FootballMatch fm, Odd o" +
            " where id.odd.id = o.id and o.footballMatch.id = fm.id and fm.id = :matchId group by id.id")
    List<IdAndTotalBet> totalBetAmountByMatchId(@Param("matchId") Long matchId);
    @Query(value = "select distinct  id.* " +
            "from   invoice_detail id ,odd o ,football_match fm " +
            "where   id.odd_id =o.id and o.match_id =fm.id and fm.id = :matchId ", nativeQuery = true)
    List<InvoiceDetail> getInvoiceDetailByMatchId(@Param("matchId") Long matchId);
}
