package com.antifake.gzzx.accountservice.conf.authentication;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AccessControlFilter extends BasicAuthenticationFilter {
    public AccessControlFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    public AccessControlFilter(AuthenticationManager authenticationManager, AuthenticationEntryPoint authenticationEntryPoint) {
        super(authenticationManager, authenticationEntryPoint);
    }
}
