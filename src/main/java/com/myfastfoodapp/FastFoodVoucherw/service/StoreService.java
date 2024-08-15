package com.myfastfoodapp.FastFoodVoucherw.service;

import java.util.List;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;

public interface StoreService {
    StoreDTO createStore(StoreDTO storeDTO);
    StoreDTO getStoreById(Long id);
    List<StoreDTO> getAllStores();
    void deleteStore(Long id);
    StoreDTO updateStore(Long id, StoreDTO storeDTO);
    
}
