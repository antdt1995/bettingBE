package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,Long> {
    @Query("select sum(id.betAmount)from InvoiceDetail id, Invoice i where id.invoice.id = i.id and i.id = :invoiceId")
    Double totalBetAmount(@Param("invoiceId")Long invoiceId);
}
