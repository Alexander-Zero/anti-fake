//package com.antifake.gzzx.accountservice.conf.authentication;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//
//import java.util.Collection;
//
///**
// * Author : Zero
// * Version: 1.0.0
// * Date   : 2020/10/14
// */
//@Getter
//@Setter
//public class SmsAuthenticationToken extends AbstractAuthenticationToken  {
//    public static final String MOBILE_REG = "^1(3|4|5|7|8)\\d{9}$";//手机号正则表达式
//
//    private Object principal;
//
//    private
//
//    public SmsAuthenticationToken(Object principal) {
//        super((Collection)null);
//        this.principal = principal;
//        this.setAuthenticated(false);
//    }
//
//    public SmsAuthenticationToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
//        super(authorities);
//        this.principal = principal;
//        super.setAuthenticated(true);
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    public Object getPrincipal() {
//        return this.principal;
//    }
//
//    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
//        if (isAuthenticated) {
//            throw new IllegalArgumentException("Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
//        } else {
//            super.setAuthenticated(false);
//        }
//    }
//
//    public void eraseCredentials() {
//        super.eraseCredentials();
//    }
//}
