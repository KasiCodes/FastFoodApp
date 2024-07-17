package com.myfastfoodapp.FastFoodVoucherw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfastfoodapp.FastFoodVoucherw.model.Voucher;

public interface VoucherRepository extends JpaRepository<Voucher,Long>{
    
    
}
