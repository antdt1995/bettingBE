package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Account;
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

    @Query(value = "SELECT a.user_name , max(i.total_bet)  " +
            "FROM account a, invoice i " +
            "WHERE a.id = i.account_id " +
            "GROUP BY a.user_name " +
            "ORDER BY max(i.total_bet) DESC " +
            "LIMIT :input", nativeQuery = true)
    List<Object[]> accountWithMaxBet(Long input);

    @Query(value = "SELECT a.user_name , count(i.id)  " +
            "FROM account a, invoice i " +
            "WHERE a.id = i.account_id " +
            "GROUP BY a.user_name " +
            "ORDER BY count(i.id) DESC " +
            "LIMIT :input", nativeQuery = true)
    List<Object[]> accountWithCountBet(Long input);

}
