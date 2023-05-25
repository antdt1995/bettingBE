package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Odd;
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

    @Query(value = "SELECT o.id  , o.odd_rate , o.set_score , o.end_date , ft.team_name , ot.odd_type " +
            " FROM football_match fm, odd o , odd_type ot, football_team ft " +
            "WHERE ft.id=fm.home_team_id and o.odd_type=ot.id and o.match_id = fm.id  AND fm.id = :matchId  ", nativeQuery = true)
    List<Object[]> findOddByMatchId(@Param("matchId") Long matchId);
}

//   "UNION " +
//            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
//            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.total_score < o.set_score AND ot.id = 4 " +
//            "UNION " +
//            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
//            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.total_score > o.set_score AND ot.id = 5)"