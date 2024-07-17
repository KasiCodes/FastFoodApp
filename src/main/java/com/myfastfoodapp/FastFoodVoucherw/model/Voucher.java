package com.myfastfoodapp.FastFoodVoucherw.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "vouchers")
public class Voucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "store_id")
    private Long storeId;


    private String code;

    private Double value;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public Voucher(){

    }
    public Voucher(String code, Double value, LocalDate expirationDate, Long storeId, Long userId) {
        this.code = code;
        this.value = value;
        this.expirationDate = expirationDate;
        this.storeId = storeId;
        this.userId = userId;
    }

    public Long getId(){
        return id;
    }
    public String getCode(){
        return code;
    }
    public Double value(){
        return value;
    }
    public LocalDate getExpiaryDate(){
        return expirationDate;
    }

    void setId(Long id){
        this.id = id;
    }
    void setCode(String code){
        this.code = code;

    }
    void setExpiaryDate(LocalDate expairyDate){
        this.expirationDate = expairyDate;
    }
    void setValue(Double value){
     this.value = value;
    }
    
    

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserInfo user;

    
}
