package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {

}
