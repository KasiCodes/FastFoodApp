package com.myfastfoodapp.FastFoodVoucherw.service;

import com.myfastfoodapp.FastFoodVoucherw.dto.UserDTO;

import java.util.List;

public interface UserService {
	List<UserDTO> getAllUsers();
	UserDTO getUserById(Long id);
	UserDTO createUser(UserDTO userDTO);
	UserDTO updateUser(Long id, UserDTO userDTO);
	void deleteUser(Long id);
}
