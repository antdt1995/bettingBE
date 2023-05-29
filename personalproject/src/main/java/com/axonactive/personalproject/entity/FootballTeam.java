package com.axonactive.personalproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "football_team")
public class FootballTeam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "team_name",nullable = false,unique = true)
    private String name;
    @Column(name = "league")
    private String league;
    @Column(name = "manager")
    private String manager;

}
