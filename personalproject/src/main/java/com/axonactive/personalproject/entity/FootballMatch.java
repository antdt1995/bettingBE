package com.axonactive.personalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "football_match")
public class FootballMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id",nullable = false)
    private FootballTeam homeTeam;

    @Column(name = "home_team_score")
    private Long homeScore;

    @ManyToOne
    @JoinColumn(name = "away_team_id",nullable = false)
    private FootballTeam awayTeam;

    @Column(name = "away_team_score")
    private Long awayScore;

    @Column(name = "total_score")
    private Long totalScore;

    @Column(name = "start_date")
    private LocalDate startDate;

    @OneToMany(mappedBy = "footballMatch")
    private List<Odd> odds;

}
