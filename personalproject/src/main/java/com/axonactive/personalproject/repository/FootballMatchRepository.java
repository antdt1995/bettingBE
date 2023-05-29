package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.FootballMatch;
import com.axonactive.personalproject.service.customDto.FootballMatchWithCountTotalBet;
import com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet;
import org.springframework.data.domain.Pageable;
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

    @Query("select new com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet(fm.id, ft.name , sum(id.betAmount)) " +
            "from FootballMatch fm  ,Odd o ,InvoiceDetail id, FootballTeam ft " +
            "where fm.homeTeam.id =ft.id   and fm.id =o.footballMatch.id and o.id =id.odd.id and fm.startDate between :fromDate and :endDate " +
            "group by fm.id ,ft.name ")
    List<FootballMatchWithTotalBet> getAllMatchWithTotalBetBetweenDate(@Param("fromDate") LocalDate fromDate, @Param("endDate") LocalDate endDate);

    @Query("SELECT new com.axonactive.personalproject.service.customDto.FootballMatchWithCountTotalBet(fm.id, ft.name, count(id.betAmount)) " +
            "FROM FootballMatch fm, Odd o, InvoiceDetail id, FootballTeam ft " +
            " where  fm.homeTeam.id = ft.id AND fm.id = o.footballMatch.id AND o.id = id.odd.id " +
            "AND fm.startDate BETWEEN :fromDate AND :endDate " +
            "GROUP BY fm.id, ft.name " +
            "ORDER BY count(id.betAmount) DESC")
    List<FootballMatchWithCountTotalBet> getAllMatchByCountTotalBet(
            @Param("fromDate") LocalDate fromDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );
    @Query("SELECT new com.axonactive.personalproject.service.customDto.FootballMatchWithTotalBet(fm.id, ft.name, sum(id.betAmount)) " +
            "FROM FootballMatch fm, Odd o, InvoiceDetail id, FootballTeam ft " +
            " where  fm.homeTeam.id = ft.id AND fm.id = o.footballMatch.id AND o.id = id.odd.id " +
            "AND fm.startDate BETWEEN :fromDate AND :endDate " +
            "GROUP BY fm.id, ft.name " +
            "ORDER BY sum(id.betAmount) DESC")
    List<FootballMatchWithTotalBet> getAllMatchByTotalBet(
            @Param("fromDate") LocalDate fromDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );


}
