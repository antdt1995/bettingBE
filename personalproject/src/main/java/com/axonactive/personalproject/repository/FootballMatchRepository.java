package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch,Long> {
    @Query(value = "SELECT distinct i.id FROM football_match fm, odd o, invoice_detail id, invoice i " +
            "WHERE o.match_id = fm.id AND id.odd_id = o.id and id.invoice_id = i.id AND fm.id = :matchId ", nativeQuery = true)
    List<Long> findInvoiceByMatchId(@Param("matchId") Long matchId);

    @Query(value = "SELECT distinct h.id FROM football_match fm, odd o, house h " +
            "WHERE o.match_id = fm.id AND h.id=o.house_id AND fm.id = :matchId ", nativeQuery = true)
    List<Long> findHouseByMatchId(@Param("matchId") Long matchId);

    @Query(value = "select fm.id, ft.team_name , sum(id.bet_amount) " +
            "from football_match fm  ,odd o ,invoice_detail id, football_team ft " +
            "where fm.home_team_id =ft.id   and fm.id =o.match_id and o.id =id.odd_id and fm.start_date between :fromDate and :endDate " +
            "group by fm.id ,ft.team_name ", nativeQuery = true)
    List<Object[]> getAllMatchWithTotalBetBetweenDate(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate);

    @Query(value = "SELECT fm.id AS matchId, SUM(id.bet_amount) AS totalBet " +
            "FROM football_match fm, odd o, invoice_detail id " +
            "WHERE fm.id = o.match_id " +
            "AND o.id = id.odd_id " +
            "AND fm.start_date BETWEEN :fromDate AND :endDate " +
            "GROUP BY fm.id " +
            "ORDER BY totalBet DESC " +
            "LIMIT :input", nativeQuery = true)
    List<Object[]> getAllMatchByTotalBet(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate,@Param("input") Long input);

    @Query(value = "SELECT fm.id AS matchId, count(id.id) AS totalBet " +
            "FROM football_match fm, odd o, invoice_detail id " +
            "WHERE fm.id = o.match_id " +
            "AND o.id = id.odd_id " +
            "AND fm.start_date BETWEEN :fromDate AND :endDate " +
            "GROUP BY fm.id " +
            "ORDER BY totalBet DESC " +
            "LIMIT :input", nativeQuery = true)
    List<Object[]> getAllMatchByCountTotalBet(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate,@Param("input") Long input);
}
