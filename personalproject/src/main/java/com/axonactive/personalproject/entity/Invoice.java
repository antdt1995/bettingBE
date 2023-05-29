package com.axonactive.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;

    @OneToMany(mappedBy = "invoice", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<InvoiceDetail>invoiceDetails;

    @Column(name = "total_bet")
    private Double totalBet;

    @Column(name ="bet_date",nullable = false)
    private LocalDate betDate;
}
