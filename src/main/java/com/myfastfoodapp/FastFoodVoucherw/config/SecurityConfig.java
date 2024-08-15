package com.myfastfoodapp.FastFoodVoucherw.config;

// package com.myfastfoodapp.FastFoodVoucherw.config;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.ObjectPostProcessor;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Autowired
//     private JwtUtil jwtUtil;

//     @Autowired
//     private UserDetailsService userDetailsService;

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf(csrf -> csrf.disable())
//                 .authorizeRequests(requests -> requests
//                         .requestMatchers("/api/users/register", "/api/users/login").permitAll()
//                         .anyRequest().authenticated()
//                         .and()
//                         .addFilterBefore(new JwtAuthorizationFilter(jwtUtil, userDetailsService), UsernamePasswordAuthenticationFilter.class));
        
//         return http.build();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//         @SuppressWarnings("unchecked")
//         AuthenticationManagerBuilder authenticationManagerBuilder = new AuthenticationManagerBuilder((ObjectPostProcessor<Object>) http.getSharedObject(AuthenticationManagerBuilder.class).getObject());
//         authenticationManagerBuilder.userDetailsService(userDetailsService);
//         return authenticationManagerBuilder.build();
//     }
// }

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
