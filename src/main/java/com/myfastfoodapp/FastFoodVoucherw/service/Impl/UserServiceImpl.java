package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import com.myfastfoodapp.FastFoodVoucherw.dto.UserDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.UserInfo;
import com.myfastfoodapp.FastFoodVoucherw.repository.UserRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> getAllUsers() {
    	return userRepository.findAll().stream()
            	.map(this::convertToDTO)
            	.collect(Collectors.toList());
	}

	@Override
	public UserDTO getUserById(Long id) {
    	UserInfo user = userRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("User not found"));
    	return convertToDTO(user);
	}

	@Override
	public UserDTO createUser(UserDTO userDTO) {
    	UserInfo user = convertToEntity(userDTO);
    	UserInfo savedUser = userRepository.save(user);
    	return convertToDTO(savedUser);
	}

	@Override
	public UserDTO updateUser(Long id, UserDTO userDTO) {
    	UserInfo user = userRepository.findById(id)
            	.orElseThrow(() -> new RuntimeException("User not found"));
    	user.setName(userDTO.getName());
    	user.setEmail(userDTO.getEmail());
    	UserInfo updatedUser = userRepository.save(user);
    	return convertToDTO(updatedUser);
	}

	@Override
	public void deleteUser(Long id) {
    	if (!userRepository.existsById(id)) {
        	throw new RuntimeException("User not found");
    	}
    	userRepository.deleteById(id);
	}

	private UserDTO convertToDTO(UserInfo user) {
    	return new UserDTO(user.getId(), user.getName(), user.getEmail());
	}

	private UserInfo convertToEntity(UserDTO userDTO) {
    	return new UserInfo(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
