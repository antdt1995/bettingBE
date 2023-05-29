package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Account;
import com.axonactive.personalproject.service.customDto.AccountWithCountBet;
import com.axonactive.personalproject.service.customDto.AccountWithMaxBet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByUserName(String userName);
    Boolean existsByUserName(String userName);
    Boolean existsByEmail(String email);

    @Query("SELECT new com.axonactive.personalproject.service.customDto.AccountWithMaxBet (a.userName, MAX(i.totalBet)) " +
            "FROM Account a ,Invoice i where a.id=i.account.id " +
            "GROUP BY a.userName " +
            "ORDER BY MAX(i.totalBet) DESC")
    List<AccountWithMaxBet> accountWithMaxBet(int limit, Pageable pageable);

    @Query("SELECT new com.axonactive.personalproject.service.customDto.AccountWithCountBet (a.userName, count(i.id))  " +
            "FROM Account a, Invoice i " +
            "WHERE a.id=i.account.id " +
            "GROUP BY a.userName " +
            "ORDER BY count(i.id) DESC ")
    List<AccountWithCountBet> accountWithCountBet(int limit, Pageable pageable);

}
