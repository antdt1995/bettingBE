package com.axonactive.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "odd")
public class Odd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "odd_type", nullable = false)
    private OddType oddType;

    @ManyToOne
    @JoinColumn(name = "match_id", nullable = false)
    private FootballMatch footballMatch;

    @OneToMany(mappedBy = "odd")
    @JsonIgnore
    private List<InvoiceDetail> invoiceDetails;

    @Column(name = "odd_rate",nullable = false)
    private Double oddRate;

    @Column(name = "set_score",nullable = false)
    private Double setScore;

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "house_id",nullable = false)
    private House house;

    private Boolean active;
}
