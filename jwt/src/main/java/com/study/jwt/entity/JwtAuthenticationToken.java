package com.study.jwt.entity;

import lombok.Getter;
import org.springframework.security.authentication.AbstractAuthenticationToken;

import javax.security.auth.Subject;

@Getter
public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private final String token;

    public JwtAuthenticationToken(String token) {
        super(null);
        this.token = token;
        setAuthenticated(false);
    }


    @Override
    public Object getCredentials() {
        return token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public boolean implies(Subject subject) {
        return super.implies(subject);
    }
}
