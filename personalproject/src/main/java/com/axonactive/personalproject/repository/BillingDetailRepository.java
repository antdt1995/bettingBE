package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.BillingDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailRepository extends JpaRepository<BillingDetail,Long> {
}
