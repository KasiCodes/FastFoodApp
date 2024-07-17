package com.myfastfoodapp.FastFoodVoucherw.service;

import java.util.List;

import com.myfastfoodapp.FastFoodVoucherw.dto.UserDTO;

public interface UserService {
    
    UserDTO registerUser(UserDTO userDTO);
    String loginUser(UserDTO userDTO);
    UserDTO getUserById(Long id);
    List<UserDTO> getAllUsers();
    void deleteUserById(Long id);
}