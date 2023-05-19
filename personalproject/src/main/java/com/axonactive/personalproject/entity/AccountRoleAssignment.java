package com.axonactive.personalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "assign_authority")

public class AccountRoleAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id",nullable = false)
    private Account account;


    @Enumerated(EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @UpdateTimestamp
    @Column(name = "modified_date")
    private LocalDateTime updatedDate;
}
