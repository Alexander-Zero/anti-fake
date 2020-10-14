package com.antifake.gzzx.accountservice.conf.authentication.delete;

import com.antifake.gzzx.accountservice.service.UserService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户校验, 密码校验
 */
@Component
public class MyAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        String encodePassword = passwordEncoder.encode(password);

        UserDetails userDetails = userService.loadUserByUsername(name);
        boolean matches = passwordEncoder.matches(password, userDetails.getPassword());
        if (!matches) {
            throw new BadCredentialsException("密码错误!");
        }

        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(name, encodePassword, userDetails.getAuthorities());
        return auth;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        if (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass))
            return true;
        return false;
    }


}
