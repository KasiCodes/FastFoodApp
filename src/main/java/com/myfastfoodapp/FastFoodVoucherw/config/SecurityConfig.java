package com.myfastfoodapp.FastFoodVoucherw.config;

import com.myfastfoodapp.FastFoodVoucherw.security.JwtAuthenticationFilter;
import com.myfastfoodapp.FastFoodVoucherw.security.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //needs to be added to bean 
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity (consider enabling it in production)
                .authorizeRequests(withDefaults())
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers(HttpMethod.GET,"/api/auth/**").permitAll() // Allow public access to authentication endpoints
                .anyRequest().authenticated() // Require authentication for all other endpoints
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager()))
                .addFilter(new JwtAuthorizationFilter(authenticationManager()));

        return http.build();
    }
    @Bean
    public UserDetailsService users(){
        UserDetails admin = User.builder()
            .username("admin")
            .password("password")
            .roles("ADMIN")
            .build();

        UserDetails user = User.builder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
            
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            new AuthenticationManagerBuilder(http.getSharedObject(BeanFactory.class));
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/webjars/**"); // Swagger UI paths
    }
}

