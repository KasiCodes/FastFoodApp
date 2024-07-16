package com.myfastfoodapp.FastFoodVoucherw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfastfoodapp.FastFoodVoucherw.dto.VoucherDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.VoucherService;


@RestController
@GetMapping("/api/vouchers")
public class VoucherController {

    @Autowired
    private VoucherService voucherService;

    @PostMapping("/buy")
    public ResponseEntity<VoucherDTO> buyVoucher( @RequestBody VoucherDTO voucherDTO){
        VoucherDTO purchasedVoucher = voucherService.buyVoucher(voucherDTO);
        return ResponseEntity.ok(purchasedVoucher);
    }

    @PostMapping("/redeem")
    public ResponseEntity<VoucherDTO> redeemVoucher(@RequestBody VoucherDTO voucherDTO){
        VoucherDTO redeemmVoucher = voucherService.redeemVoucher(voucherDTO);
        return ResponseEntity.ok(redeemmVoucher);
    }
    @PostMapping("/transfer")
    public ResponseEntity<VoucherDTO> transferVoucher(@RequestBody VoucherDTO voucherDTO){
        VoucherDTO transferedVoucher = voucherService.transferVoucher(voucherDTO);
        return ResponseEntity.ok(transferedVoucher);

    }

    @GetMapping()
    public ResponseEntity<List<VoucherDTO>> getAllVouchers(){
        List<VoucherDTO> vouchers = voucherService.getAllVouchers();
        return ResponseEntity.ok(vouchers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<VoucherDTO> getVoucherById(@PathVariable Long id){
        VoucherDTO voucherDTO = voucherService.getVoucherById(id);
        return ResponseEntity.ok(voucherDTO);
    }
}
