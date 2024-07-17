package com.myfastfoodapp.FastFoodVoucherw.service;

import java.util.List;

import com.myfastfoodapp.FastFoodVoucherw.dto.VoucherDTO;

public interface VoucherService {
    VoucherDTO buyVoucher(VoucherDTO voucherDTO);
    VoucherDTO redeemVoucher(VoucherDTO voucherDTO);
    VoucherDTO transferVoucher(VoucherDTO voucherDTO);
    VoucherDTO getVoucherById(Long id);
    List<VoucherDTO> getAllVouchers();
    void deleteVoucher(Long id);
    VoucherDTO updateVoucher(Long id, VoucherDTO voucherDTO);

    
}
