package com.study.jwt.config;

import com.study.jwt.filter.JWTValidationFilter;
import com.study.jwt.filter.JwtAuthenticationFilter;
import com.study.jwt.provider.JwtAuthenticationProvider;
import com.study.jwt.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class Config {

    private JWTUtils jwtUtils;
    private UserDetailsService userDetailsService;

    @Autowired
    public Config(JWTUtils jwtUtils, UserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(createPasswordEncoder());
        return provider;
    }

    @Bean
    public JwtAuthenticationProvider createJwtAuthenticationProvider() {
        JwtAuthenticationProvider provider = new JwtAuthenticationProvider(jwtUtils,userDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity,AuthenticationManager authenticationManager,JWTUtils jwtUtils) throws Exception {

        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager, jwtUtils);
        JWTValidationFilter jWTValidationFilter = new JWTValidationFilter(authenticationManager, jwtUtils);
        httpSecurity.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/addUser","/login").permitAll()
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(Customizer.withDefaults())
                .logout(LogoutConfigurer::permitAll)
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults())
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(jWTValidationFilter, JwtAuthenticationFilter.class);
        return httpSecurity.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity httpSecurity) throws Exception {
        return new ProviderManager(Arrays.asList(daoAuthenticationProvider(),createJwtAuthenticationProvider()));
    }
}

