package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.myfastfoodapp.FastFoodVoucherw.model.Store;
import com.myfastfoodapp.FastFoodVoucherw.model.UserInfo;
import org.springframework.beans.BeanUtils;
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
        voucher.setCode(voucherDTO.getCode());;
        voucher.setValue(voucherDTO.getValue());
        voucher.setExpirationDate(voucherDTO.getExpirationDate());
        Store store = fetchStoreById(voucherDTO.getStoreId());
        UserInfo user = fetchUserById(voucherDTO.getUserId());
        voucher.setStore(store);
        voucher.setUser(user);
        Voucher savedVoucher = voucherRepository.save(voucher);
        return mapToDTO(savedVoucher);
    } 
    @Override
    public VoucherDTO redeemVoucher(VoucherDTO voucherDTO) {
        Voucher voucher = voucherRepository.findById(voucherDTO.getId()).orElse(null);
        if (voucher != null && voucher.getId().equals(voucherDTO.getUserId())) {
            // Perform voucher redemption logic
            voucherRepository.delete(voucher);
            return mapToDTO(voucher);
        }
        return null;
    }
    @Override
    public VoucherDTO transferVoucher(VoucherDTO voucherDTO) {
        Voucher voucher = voucherRepository.findById(voucherDTO.getId()).orElse(null);
        if (voucher != null && voucher.getUser().getId().equals(voucherDTO.getUserId())) {
            // Perform voucher transfer logic
            UserInfo newUser = fetchUserById(voucherDTO.getUserId());
            voucher.setUser(newUser);
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
        voucherDTO.setExpiaryDate(voucher.getExpirationDate());
        voucherDTO.setStoreId(voucher.getStore().getId());
        voucherDTO.setUserId(voucher.getUser().getId());
        return voucherDTO;
    }
    public boolean deleteVoucher(Long id) {
        if (voucherRepository.existsById(id)) {
            voucherRepository.deleteById(id);
            return true; // Deletion successful
        }
        return false; // Voucher not found
    }
    @Override
    public VoucherDTO updateVoucher(Long id, VoucherDTO voucherDTO) {
        Optional<Voucher> optionalVoucher = voucherRepository.findById(id);
        if (optionalVoucher.isPresent()) {
            Voucher existingVoucher = optionalVoucher.get();
            // Update existing voucher with data from voucherDTO
            BeanUtils.copyProperties(voucherDTO, existingVoucher);
            existingVoucher.setId(id); // Ensure ID is set correctly
            // Save and return updated voucher
            return convertToDto(voucherRepository.save(existingVoucher));
        }
        // Handle not found scenario, throw exception or return null as needed
        return null;
    }
    private VoucherDTO convertToDto(Voucher voucher) {
        VoucherDTO voucherDTO = new VoucherDTO();
        BeanUtils.copyProperties(voucher, voucherDTO);
        return voucherDTO;
    }
    private UserInfo fetchUserById(Long userId) {
        // Implement the actual logic to fetch UserInfo by ID
        return new UserInfo();
    }
    private Store fetchStoreById(Long storeId) {
        // Implement the actual logic to fetch Store by ID
        return new Store();
    }
  
}
