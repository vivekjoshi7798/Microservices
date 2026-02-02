package com.study.jwt.provider;

import com.study.jwt.entity.JwtAuthenticationToken;
import com.study.jwt.utils.JWTUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private JWTUtils jwtUtils;
    private UserDetailsService userDetailsService;

    public JwtAuthenticationProvider(JWTUtils jwtUtils, UserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = ((JwtAuthenticationToken) authentication).getToken();
        Claims usernameCliam = jwtUtils.validateToken(token);
        String username = usernameCliam.getSubject();

        if (username == null) {
            throw new BadCredentialsException("Invlidate JWT Token");
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
