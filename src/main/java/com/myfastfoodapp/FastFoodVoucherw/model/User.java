package com.myfastfoodapp.FastFoodVoucherw.model;

import org.hibernate.mapping.List;
import java.util.*;

import jakarta.persistence.*;

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
