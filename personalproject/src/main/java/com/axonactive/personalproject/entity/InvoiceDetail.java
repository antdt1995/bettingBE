package com.axonactive.personalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JoinColumn(name = "invoice_id",nullable = false)
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "odd_id",nullable = false)
    private Odd odd;

    @Column(name = "bet_amount",nullable = false)
    private Double betAmount;

    @Column(name = "payment_status")
    private Boolean paymentStatus;
    @CreationTimestamp
    @Column(name ="bet_date",nullable = false)
    private LocalDateTime betDate;
}
