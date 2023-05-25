package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch,Long> {
    @Query(value = "SELECT distinct i.id FROM football_match fm, odd o, invoice_detail id, invoice i " +
            "WHERE o.match_id = fm.id AND id.odd_id = o.id and id.invoice_id = i.id AND fm.id = :matchId ", nativeQuery = true)
    List<Long> findInvoiceByMatchId(@Param("matchId") Long matchId);

    @Query(value = "SELECT distinct h.id FROM football_match fm, odd o, house h " +
            "WHERE o.match_id = fm.id AND h.id=o.house_id AND fm.id = :matchId ", nativeQuery = true)
    List<Long> findHouseByMatchId(@Param("matchId") Long matchId);
}
