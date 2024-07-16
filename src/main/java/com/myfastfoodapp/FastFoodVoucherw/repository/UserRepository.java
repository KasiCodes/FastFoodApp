package com.myfastfoodapp.FastFoodVoucherw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfastfoodapp.FastFoodVoucherw.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
