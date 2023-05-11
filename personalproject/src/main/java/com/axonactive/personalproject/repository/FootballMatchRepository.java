package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.FootballMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballMatchRepository extends JpaRepository<FootballMatch,Long> {
}
