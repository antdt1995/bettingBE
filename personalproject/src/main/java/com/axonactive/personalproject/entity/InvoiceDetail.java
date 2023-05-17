package com.axonactive.personalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invoice_detail")
public class InvoiceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bill_id",nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "odd_id",nullable = false)
    private Odd odd;

    @Column(name = "bet_amount")
    private Double betAmount;

}
