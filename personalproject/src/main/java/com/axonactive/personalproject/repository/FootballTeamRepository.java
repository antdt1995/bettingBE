package com.axonactive.personalproject.repository;


import com.axonactive.personalproject.entity.FootballTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootballTeamRepository extends JpaRepository<FootballTeam,Long> {
}
