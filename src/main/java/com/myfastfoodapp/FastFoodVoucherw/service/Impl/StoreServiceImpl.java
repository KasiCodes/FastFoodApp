package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import com.myfastfoodapp.FastFoodVoucherw.dto.StoreDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.Store;
import com.myfastfoodapp.FastFoodVoucherw.repository.StoreRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<StoreDTO> getAllStores() {
    	return storeRepository.findAll().stream()
            	.map(this::convertToDTO)
            	.collect(Collectors.toList());
	}

	@Override
	public StoreDTO getStoreById(Long id) {
    	Store store = storeRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Store not found"));
    	return convertToDTO(store);
	}

	@Override
	public StoreDTO createStore(StoreDTO storeDTO) {
    	Store store = convertToEntity(storeDTO);
    	Store savedStore = storeRepository.save(store);
    	return convertToDTO(savedStore);
	}

	@Override
	public StoreDTO updateStore(Long id, StoreDTO storeDTO) {
    	Store store = storeRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("Store not found"));
    	store.setName(storeDTO.getName());
    	store.setLocation(storeDTO.getLocation());
    	Store updatedStore = storeRepository.save(store);
    	return convertToDTO(updatedStore);
	}

	@Override
	public void deleteStore(Long id) {
    	if (!storeRepository.existsById(id)) {
        	throw new RuntimeException("Store not found");
    	}
    	storeRepository.deleteById(id);
	}

	private StoreDTO convertToDTO(Store store) {
    	return new StoreDTO(store.getId(), store.getName(), store.getLocation());
	}

	private Store convertToEntity(StoreDTO storeDTO) {
    	return new Store(storeDTO.getId(), storeDTO.getName(), storeDTO.getLocation());
	}
}
