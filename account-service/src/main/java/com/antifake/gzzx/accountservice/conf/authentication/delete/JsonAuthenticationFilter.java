//package com.antifake.gzzx.accountservice.conf.authentication;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.http.MediaType;
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Author : Zero
// * Version: 1.0.0
// * Date   : 2020/10/13
// * 用于实现json 登录
// */
//
//public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if (!request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }
//        if (request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
//            Map<String, String> map = new HashMap<>();
//            try {
//                map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            String mobile = map.get("mobile");
//            String username = map.get("userName");
//
//            if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(username)) {
//                throw new BadCredentialsException("认证方式不明确!");
//            }
//
//            Authentication authRequest;
//            if (StringUtils.isNoneBlank(mobile)) {
//                String smsCode = map.get("smsCode");
//                if (smsCode == null) {
//                    smsCode = "";
//                }
//                authRequest = new SmsCodeAuthenticationToken(mobile, smsCode);
//            } else {
//                String password = map.get("password");
//                if (username == null) {
//                    username = "";
//                }
//                if (password == null) {
//                    password = "";
//                }
//                username = username.trim();
//                authRequest = new UsernamePasswordAuthenticationToken(username, password);
//            }
//
//            this.setDetails(request, authRequest);
//            return this.getAuthenticationManager().authenticate(authRequest);
//        }
//
//        return super.attemptAuthentication(request, response);
//    }
//
//
//}
