package com.myfastfoodapp.FastFoodVoucherw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myfastfoodapp.FastFoodVoucherw.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByEmail(String email);
}
