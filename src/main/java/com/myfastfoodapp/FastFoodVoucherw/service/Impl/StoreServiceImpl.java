package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.Store;
import com.myfastfoodapp.FastFoodVoucherw.repository.StoreRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.StoreService;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

     @Override
    public StoreDTO createStore(StoreDTO storeDTO) {
        Store store = new Store();
        store.setName(storeDTO.getName());
        store.setLocation(storeDTO.getLocation());
        Store savedStore = storeRepository.save(store);
        return mapToDTO(savedStore);
    }
    @Override
    public StoreDTO getStoreById(Long id) {
        Store store = storeRepository.findById(id).orElse(null);
        return mapToDTO(store);
    }
    @Override
    public List<StoreDTO> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private StoreDTO mapToDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setName(store.getName());
        storeDTO.setLocation(store.getLocation());
        return storeDTO;
    }
    
}
