package com.axonactive.personalproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(	name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Invoice> invoices;


    @OneToMany(mappedBy = "account",cascade = CascadeType.PERSIST)
    private List<AccountRoleAssignment> roles=new ArrayList<>();

    @OneToMany(mappedBy = "account")
    private List<House> house;

    private Boolean active;

    @Column(name = "user_name", nullable = false, unique = true)
    private String userName;

    @Column(name = "email",unique = true)
    private String email;

    @Column(name = "user_password",nullable = false)
    private String userPassword;

    @Column(name = "total_balance")
    private Double totalBalance;

    public Account(String userName, String email, String userPassword, Double totalBalance) {
        this.userName = userName;
        this.email = email;
        this.userPassword = userPassword;
        this.totalBalance = totalBalance;
    }
}
