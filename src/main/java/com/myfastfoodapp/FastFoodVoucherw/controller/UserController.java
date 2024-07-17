package com.myfastfoodapp.FastFoodVoucherw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myfastfoodapp.FastFoodVoucherw.dto.UserDTO;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService UserService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
        UserDTO createdUser = UserService.registerUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO){
        String token = UserService.loginUser(userDTO);
        return ResponseEntity.ok(token);

    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO>getUserById(@PathVariable Long id){
        UserDTO userDTO = UserService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping
    public ResponseEntity<UserDTO> getAllUsers(){
        List<UserDTO> users = UserService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
}
