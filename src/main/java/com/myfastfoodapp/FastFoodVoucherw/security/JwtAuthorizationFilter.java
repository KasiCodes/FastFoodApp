package com.myfastfoodapp.FastFoodVoucherw.security;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends UsernamePasswordAuthenticationFilter {

    // Constructor
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        // Extract JWT token from the request and validate it
        // Set authentication in the SecurityContext if the token is valid
    }
}
