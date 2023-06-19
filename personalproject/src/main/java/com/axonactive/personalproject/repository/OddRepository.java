package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Odd;
import com.axonactive.personalproject.service.customDto.OddCustomDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddRepository extends JpaRepository<Odd, Long> {
    //do not touch, get odd id win,draw, lose base on each match
    @Query(value = "SELECT o.id FROM odd o, football_match fm " +
            "WHERE fm.id = o.match_id AND fm.id = :matchId AND o.id IN (" +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score > fm.away_team_score AND ot.id = 1 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score = fm.away_team_score AND ot.id = 2 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score < fm.away_team_score AND ot.id = 3)"
            , nativeQuery = true)
    Long findWinLoseOddIds(@Param("matchId") Long matchId);

    //get odd id over base on each match
    @Query(value = "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
                      "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.id = :matchId AND ot.id = 4", nativeQuery = true)
    Long findOverOddId(@Param("matchId") Long matchId);

    //get odd id under base on each match
    @Query(value = "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.id = :matchId AND ot.id = 5 ", nativeQuery = true)
    Long findUnderOddId(@Param("matchId") Long matchId);

    @Query("SELECT  new com.axonactive.personalproject.service.customDto.OddCustomDto(o.id, ot.name, ft.name, o.oddRate, o.setScore, o.endDate)  " +
            " FROM FootballMatch fm , FootballTeam ft, Odd o, OddType ot " +
            "WHERE fm.homeTeam.id = ft.id AND o.footballMatch.id = fm.id AND o.oddType.id = ot.id" +
            " and fm.id = :matchId  ")
    List<OddCustomDto> findOddByMatchId(@Param("matchId") Long matchId);

    @Query(value = "SELECT SUM(id.bet_Amount) " +
            "FROM football_match fm , invoice_detail id, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id " +
            "AND o.odd_type = ot.id " +
            "AND o.id = id.odd_id " +
            "AND ot.id = 1 " +
            "AND fm.id = :matchId " +
            "UNION " +
            "SELECT SUM(id.bet_Amount) " +
            "FROM football_match fm , invoice_detail id, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id " +
            "AND o.odd_type = ot.id " +
            "AND o.id = id.odd_id " +
            "AND ot.id = 2 " +
            "AND fm.id = :matchId " +
            "UNION " +
            "SELECT SUM(id.bet_Amount) " +
            "FROM football_match fm , invoice_detail id, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id " +
            "AND o.odd_type = ot.id " +
            "AND o.id = id.odd_id " +
            "AND ot.id = 3 " +
            "AND fm.id = :matchId " +
            "UNION " +
            "SELECT SUM(id.bet_Amount) " +
            "FROM football_match fm , invoice_detail id, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id " +
            "AND o.odd_type = ot.id " +
            "AND o.id = id.odd_id " +
            "AND ot.id = 4 " +
            "AND fm.id = :matchId " +
            "UNION " +
            "SELECT SUM(id.bet_Amount) " +
            "FROM football_match fm , invoice_detail id, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id " +
            "AND o.odd_type = ot.id " +
            "AND o.id = id.odd_id " +
            "AND ot.id = 5 " +
            "AND fm.id = :matchId ",nativeQuery = true)
    List<Double> findTotalBetAmountOfEachOddByMatchID(@Param("matchId") Long matchId);


//    @Query(value = "SELECT o.id FROM odd o, football_match fm " +
//            "WHERE fm.id = o.match_id AND fm.id = :matchId AND o.id IN (" +
//            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
//            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score > fm.away_team_score AND ot.id = 1 " +
//            "UNION " +
//            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
//            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score = fm.away_team_score AND ot.id = 2 " +
//            "UNION " +
//            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
//            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score < fm.away_team_score AND ot.id = 3)"
//            , nativeQuery = true)
//    List<Long> findWinLoseOddIds(@Param("matchId") Long matchId);
}
