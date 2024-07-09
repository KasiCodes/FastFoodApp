package com.myfastfoodapp.FastFoodVoucherw.model;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;
    private Double walletBalance;

    @OneToMany(mappedBy = "user")
    private List<Voucher> vouchers;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transaction;

    
}
