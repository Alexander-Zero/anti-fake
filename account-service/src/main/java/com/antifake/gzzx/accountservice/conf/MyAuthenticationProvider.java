package com.antifake.gzzx.accountservice.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        String encodePassword = passwordEncoder.encode(password);
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.authenticate(authentication);

//UsernamePasswordAuthenticationToken

        List<GrantedAuthority> resource = new ArrayList<>();
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, encodePassword, resource);
        return auth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        if (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass))
            return true;
        return false;
    }


}
