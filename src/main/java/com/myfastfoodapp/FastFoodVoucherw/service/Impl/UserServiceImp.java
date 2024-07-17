package com.myfastfoodapp.FastFoodVoucherw.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myfastfoodapp.FastFoodVoucherw.dto.UserDTO;
import com.myfastfoodapp.FastFoodVoucherw.model.UserInfo;
import com.myfastfoodapp.FastFoodVoucherw.repository.UserRepository;
import com.myfastfoodapp.FastFoodVoucherw.service.UserService;


@Service
public class UserServiceImp  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO){
        UserInfo user = new UserInfo();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setWalletBalance(0.0);
        UserInfo savedUser = userRepository.save(user);
        
        return mapToDTO(savedUser);

    }
    @Override
    public String loginUser(UserDTO userDTO) {
        UserInfo user = userRepository.findByEmail(userDTO.getEmail());
        if (user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            // Generate and return JWT token
            return "jwt-token"; // Replace with actual token generation logic
        }
        return null;
    }

    @Override
    public UserDTO getUserById(Long id) {
        UserInfo user = userRepository.findById(id).orElse(null);
        return mapToDTO(user);
    }
    @Override
    public List<UserDTO> getAllUsers() {
        List<UserInfo> users = userRepository.findAll();
        return users.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
    private UserDTO mapToDTO(UserInfo user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setWalletBalance(user.getWalletBalance());
        return userDTO;
    }
}

   
