package com.axonactive.personalproject.repository;

import com.axonactive.personalproject.entity.Odd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OddRepository extends JpaRepository<Odd, Long> {
    //do not touch
    @Query(value = "SELECT o.id FROM odd o, football_match fm " +
            "WHERE fm.id = o.match_id AND fm.id = :matchId AND o.id IN (" +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score > fm.away_team_score AND ot.id = 1 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score = fm.away_team_score AND ot.id = 2 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.home_team_score < fm.away_team_score AND ot.id = 3 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.total_score < o.set_score AND ot.id = 4 " +
            "UNION " +
            "SELECT o.id FROM football_match fm, odd o, odd_type ot " +
            "WHERE o.match_id = fm.id AND o.odd_type = ot.id AND fm.total_score > o.set_score AND ot.id = 5)"
            , nativeQuery = true)
    List<Long> findOddIds(@Param("matchId") Long matchId);


}