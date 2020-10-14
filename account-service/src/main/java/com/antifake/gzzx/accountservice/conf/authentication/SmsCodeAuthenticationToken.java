package com.antifake.gzzx.accountservice.conf.authentication;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken implements RoleIdHolder {
    private final Object principal;
    private String credentials;
    private List<Long> roleIds;

    public SmsCodeAuthenticationToken(Object principal, String credentials) {
        super((Collection) null);
        this.principal = principal;
        this.credentials = credentials;
        this.setAuthenticated(false);
    }

    public SmsCodeAuthenticationToken(Object principal, List<Long> roleIds, List<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        this.roleIds = roleIds;
        super.setAuthenticated(true);
    }

    public Object getCredentials() {
        return this.credentials;
    }

    public Object getPrincipal() {
        return this.principal;
    }

    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        if (isAuthenticated) {
            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
        } else {
            super.setAuthenticated(false);
        }
    }

    public void eraseCredentials() {
        super.eraseCredentials();
        this.credentials = null;
    }

    @Override
    public List<Long> getRoleIds() {
        return null;
    }

}
