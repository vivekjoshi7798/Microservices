package com.study.jwt.service;

import com.study.jwt.repository.*;
import lombok.extern.slf4j.Slf4j;
import com.study.jwt.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientUserRegistrationService implements UserDetailsService {
    @Autowired
    ClientUserRepository clientUserRepository;

    public void addUser(ClientUser clientUser) {
        clientUserRepository.save(clientUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return clientUserRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User not found with username: " + username));

    }

}
