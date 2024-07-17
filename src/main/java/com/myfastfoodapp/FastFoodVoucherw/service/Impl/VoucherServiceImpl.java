package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myfastfoodapp.FastFoodVoucherw.dto.VoucherDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.Voucher;
import com.myfastfoodapp.FastFoodVoucherw.repository.VoucherRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.VoucherService;


@Service
public class VoucherServiceImpl implements VoucherService{

    @Autowired
    private VoucherRepository voucherRepository;

    @Override
    public VoucherDTO buyVoucher(VoucherDTO voucherDTO){
        Voucher voucher = new Voucher();
        voucher.setCode(VoucherDTO.getCode());

    } 



    
}
