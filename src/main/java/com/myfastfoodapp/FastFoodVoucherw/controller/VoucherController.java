package com.myfastfoodapp.FastFoodVoucherw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfastfoodapp.FastFoodVoucherw.dto.VoucherDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.VoucherService;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping("/buy")
    public ResponseEntity<VoucherDTO> buyVoucher(@RequestBody VoucherDTO voucherDTO) {
        VoucherDTO purchasedVoucher = voucherService.buyVoucher(voucherDTO);
        return ResponseEntity.status(201).body(purchasedVoucher); // 201 Created status
    }

    @PostMapping("/redeem")
    public ResponseEntity<VoucherDTO> redeemVoucher(@RequestBody VoucherDTO voucherDTO) {
        VoucherDTO redeemedVoucher = voucherService.redeemVoucher(voucherDTO);
        return ResponseEntity.ok(redeemedVoucher);
    }

    @PostMapping("/transfer")
    public ResponseEntity<VoucherDTO> transferVoucher(@RequestBody VoucherDTO voucherDTO) {
        VoucherDTO transferredVoucher = voucherService.transferVoucher(voucherDTO);
        return ResponseEntity.ok(transferredVoucher);
    }

    @GetMapping
    public ResponseEntity<List<VoucherDTO>> getAllVouchers() {
        List<VoucherDTO> vouchers = voucherService.getAllVouchers();
        return ResponseEntity.ok(vouchers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VoucherDTO> getVoucherById(@PathVariable Long id) {
        VoucherDTO voucherDTO = voucherService.getVoucherById(id);
        if (voucherDTO == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(voucherDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoucher(@PathVariable Long id) {
    boolean isDeleted = voucherService.deleteVoucher(id);
    if (isDeleted) {
        return ResponseEntity.noContent().build(); // 204 No Content
    }
    return ResponseEntity.notFound().build(); // 404 Not Found
}

    @PutMapping("/{id}")
    public ResponseEntity<VoucherDTO> updateVoucher(@PathVariable Long id, @RequestBody VoucherDTO voucherDTO) {
        VoucherDTO updatedVoucher = voucherService.updateVoucher(id, voucherDTO);
        if (updatedVoucher == null) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(updatedVoucher);
    }
}
