package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import java.util.stream.Collectors;

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
        voucher.setValue(voucherDTO.getValue());
        voucher.setExpirationDate(voucherDTO.getExpirationDate());
        voucher.setStoreId(voucherDTO.getStoreId());
        voucher.setUserId(voucherDTO.getUserId());
        Voucher savedVoucher = voucherRepository.save(voucher);
        return mapToDTO(savedVoucher);
    } 
    @Override
    public VoucherDTO redeemVoucher(VoucherDTO voucherDTO) {
        Voucher voucher = voucherRepository.findById(voucherDTO.getId()).orElse(null);
        if (voucher != null && voucher.getUserId().equals(voucherDTO.getUserId())) {
            // Perform voucher redemption logic
            voucherRepository.delete(voucher);
            return mapToDTO(voucher);
        }
        return null;
    }
    @Override
    public VoucherDTO transferVoucher(VoucherDTO voucherDTO) {
        Voucher voucher = voucherRepository.findById(voucherDTO.getId()).orElse(null);
        if (voucher != null && voucher.getUserId().equals(voucherDTO.getUserId())) {
            // Perform voucher transfer logic
            voucher.setUserId(voucherDTO.getUserId());
            Voucher updatedVoucher = voucherRepository.save(voucher);
            return mapToDTO(updatedVoucher);
        }
        return null;
    }
    @Override
    public VoucherDTO getVoucherById(Long id) {
        Voucher voucher = voucherRepository.findById(id).orElse(null);
        return mapToDTO(voucher);
    }

    @Override
    public List<VoucherDTO> getAllVouchers() {
        List<Voucher> vouchers = voucherRepository.findAll();
        return vouchers.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private VoucherDTO mapToDTO(Voucher voucher) {
        if (voucher == null) {
            return null;
        }
        VoucherDTO voucherDTO = new VoucherDTO();
        voucherDTO.setId(voucher.getId());
        voucherDTO.setCode(voucher.getCode());
        voucherDTO.setValue(voucher.getValue());
        voucherDTO.setExpirationDate(voucher.getExpirationDate());
        voucherDTO.setStoreId(voucher.getStoreId());
        voucherDTO.setUserId(voucher.getUserId());
        return voucherDTO;
    }




    
}
