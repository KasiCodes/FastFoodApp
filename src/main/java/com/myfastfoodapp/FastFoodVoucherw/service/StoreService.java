package com.myfastfoodapp.FastFoodVoucherw.service;

import java.util.List;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;

public interface StoreService {
    StoreDTO creaStore(StoreDTO storeDTO);
    StoreDTO getStoreById(Long id);
    List<StoreDTO> getAllStores();
    
}
