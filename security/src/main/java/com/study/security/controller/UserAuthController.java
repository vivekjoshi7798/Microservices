package com.study.security.controller;

import com.study.security.service.*;
import com.study.security.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthController {


    @Autowired
    UserAuthService userAuthService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login() {
        return "login"; // login.html
    }
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody UserAuthEntity userAuthEntity) {
        userAuthEntity.setPassword(passwordEncoder.encode(userAuthEntity.getPassword()));
        userAuthService.addUser(userAuthEntity);
        return ResponseEntity.ok("User added successfully");
    }

}
