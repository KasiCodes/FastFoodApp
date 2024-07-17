package com.myfastfoodapp.FastFoodVoucherw.model;


import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "users")

public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Column(name = "wallet_balance")
    private double walletBalance;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Voucher> vouchers;

    
    // Default constructor
    public UserInfo() {}

    // Constructor with fields
    public UserInfo(String name, String email, String password, Double walletBalance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.walletBalance = walletBalance;
    }


    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public double getWalletBalance(){
        return walletBalance;
    }
    public void setId(Long id){
        this.id = id;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setWalletBalance(Double walletBalance){
        this.walletBalance = walletBalance;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<Voucher> vouchers) {
        this.vouchers = vouchers;
    }   
}
