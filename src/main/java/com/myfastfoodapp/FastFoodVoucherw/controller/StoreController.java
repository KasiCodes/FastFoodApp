package com.myfastfoodapp.FastFoodVoucherw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;
import com.myfastfoodapp.FastFoodVoucherw.dto.VoucherDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.StoreService;

@RestController
@GetMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO){
        StoreDTO createdStore = storeService.createStore(storeDTO);
        return ResponseEntity.ok(createdStore); 
    }

    @GetMapping()
    public ResponseEntity<List<StoreDTO>> getAllStores(){
        List<StoreDTO> storeDTO = storeService.getAllStores();
        return ResponseEntity.ok(storeDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id){
        StoreDTO storedDTO = storeService.getStoreById(id);
        return ResponseEntity.ok(storedDTO);
    }




    
}
