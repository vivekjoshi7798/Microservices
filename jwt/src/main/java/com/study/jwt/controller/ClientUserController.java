package com.study.jwt.controller;

import com.study.jwt.entity.ClientUser;
import com.study.jwt.service.ClientUserRegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
@Slf4j
public class ClientUserController {

    @Autowired
    ClientUserRegistrationService userAuthService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody ClientUser userAuthEntity) {
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));
        userAuthService.addUser(userAuthEntity);
        return ResponseEntity.ok("User added successfully");
    }

    @GetMapping("/seeDetails")
    public String seeDetails() {
       return "API to see user details";
    }

    @GetMapping("/userDetails")
    public ClientUser getUserDetails() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
         return (ClientUser) authentication.getPrincipal();

    }

}
