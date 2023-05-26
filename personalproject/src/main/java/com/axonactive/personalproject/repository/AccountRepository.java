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

    @Query(value = "SELECT a.user_name AS matchId, max(i.id) AS totalBet " +
            "FROM account a, invoice i " +
            "WHERE fm.id = o.match_id " +
            "AND o.id = id.odd_id " +
            "GROUP BY a.user_name " +
            "ORDER BY totalBet DESC " +
            "LIMIT :input", nativeQuery = true)
    List<Object[]> accountWithMaxBet(Long input);

}
