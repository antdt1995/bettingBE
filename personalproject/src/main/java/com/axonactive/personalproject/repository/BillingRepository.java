package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingRepository extends JpaRepository<Invoice,Long> {
}
