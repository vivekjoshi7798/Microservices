package com.study.jwt.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.jwt.entity.LoginRequest;
import com.study.jwt.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtil;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtils jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        if (!request.getServletPath().equals("/generateToken")) {
            filterChain.doFilter(request, response);
            return;
        }

        ObjectMapper mapper = new ObjectMapper();
        LoginRequest loginRequest = mapper.readValue(request.getInputStream(), LoginRequest.class);


        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
        Authentication authResult = authenticationManager.authenticate(token);

        if (authResult.isAuthenticated()) {
            String newToken = jwtUtil.generateAccessToken(authResult.getName());
            response.setHeader("Authorization", "Bearer " + newToken);
        }
    }


}
