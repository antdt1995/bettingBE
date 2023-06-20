package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    @Query("SELECT i " +
            "FROM Invoice i, Account a " +
            "WHERE i.account.id = a.id " +
            "AND a.userName like :userName")
    List<Invoice> findByUsername(@Param("userName") String username);
}
