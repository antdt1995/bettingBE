package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccount(Account account);

}
