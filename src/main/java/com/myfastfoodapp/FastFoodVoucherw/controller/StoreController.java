package com.myfastfoodapp.FastFoodVoucherw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;
import com.myfastfoodapp.FastFoodVoucherw.service.StoreService;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping
	public ResponseEntity<StoreDTO> createStore(@RequestBody StoreDTO storeDTO) {
    	StoreDTO createdStore = storeService.createStore(storeDTO);
    	return new ResponseEntity<>(createdStore, HttpStatus.CREATED);
	}


    @GetMapping
	public ResponseEntity<List<StoreDTO>> getAllStores() {
    	List<StoreDTO> stores = storeService.getAllStores();
    	return new ResponseEntity<>(stores, HttpStatus.OK);
	}


    @GetMapping("/{id}")
	public ResponseEntity<StoreDTO> getStoreById(@PathVariable Long id) {
    	StoreDTO store = storeService.getStoreById(id);
    	return new ResponseEntity<>(store, HttpStatus.OK);
	}


    @DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
    	storeService.deleteStore(id);
    	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
    @PutMapping("/{id}")
	public ResponseEntity<StoreDTO> updateStore(@PathVariable Long id, @RequestBody StoreDTO storeDTO) {
    	StoreDTO updatedStore = storeService.updateStore(id, storeDTO);
    	return new ResponseEntity<>(updatedStore, HttpStatus.OK);
	}


}
