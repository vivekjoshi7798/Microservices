package com.study.security.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/auth/addUser","/login").permitAll()
                    .anyRequest().authenticated()
            )
                .formLogin(form-> form.loginPage("/login").defaultSuccessUrl("/",true).permitAll())
                .logout(LogoutConfigurer::permitAll)
                .csrf(AbstractHttpConfigurer::disable)
            .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }

}
