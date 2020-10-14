package com.antifake.gzzx.accountservice.conf.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.lang.Nullable;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 * 短信验证码 和 账号密码认证过滤器
 */
public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_USERNAME_KEY = "username";
    public static final String SPRING_SECURITY_FORM_PASSWORD_KEY = "password";
    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "mobile";
    public static final String SPRING_SECURITY_FORM_SMS_CODE_KEY = "smsCode";
    private String usernameParameter = "username";
    private String passwordParameter = "password";
    private String mobileParameter = "mobile";
    private String smsCodeParameter = "smsCode";

    private boolean postOnly = true;

    protected CustomAuthenticationFilter() {
        super(new AntPathRequestMatcher("/login", "POST"));
    }

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (this.postOnly && !request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }

        if (!request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {
            throw new AuthenticationServiceException("只支持POST+JSON登录" );
        }

        Map<String, String> map = new HashMap<>();
        try {
            map = new ObjectMapper().readValue(request.getInputStream(), Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String mobile = map.get("mobile");
        String username = map.get("userName");

        if (StringUtils.isNotBlank(mobile) && StringUtils.isNotBlank(username)) {
            throw new BadCredentialsException("认证方式不明确!");
        }

        AbstractAuthenticationToken authRequest;

        //手机验证码认证
        if (StringUtils.isNoneBlank(mobile)) {
            String smsCode = map.get("smsCode");
            if (smsCode == null) {
                smsCode = "";
            }
            authRequest = new SmsCodeAuthenticationToken(mobile, smsCode);
        }
        //账号密码认证
        else {
            String password = map.get("password");
            if (username == null) {
                username = "";
            }
            if (password == null) {
                password = "";
            }
            username = username.trim();
            authRequest = new CustomUsernamePasswordAuthenticationToken(username, password);
        }

        this.setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);

    }

    @Nullable
    protected String obtainPassword(HttpServletRequest request) {
        return request.getParameter(this.passwordParameter);
    }

    @Nullable
    protected String obtainUsername(HttpServletRequest request) {
        return request.getParameter(this.usernameParameter);
    }

    protected void setDetails(HttpServletRequest request, AbstractAuthenticationToken authRequest) {
        authRequest.setDetails(this.authenticationDetailsSource.buildDetails(request));
    }

    public void setUsernameParameter(String usernameParameter) {
        Assert.hasText(usernameParameter, "Username parameter must not be empty or null");
        this.usernameParameter = usernameParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        Assert.hasText(passwordParameter, "Password parameter must not be empty or null");
        this.passwordParameter = passwordParameter;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

    public final String getUsernameParameter() {
        return this.usernameParameter;
    }

    public final String getPasswordParameter() {
        return this.passwordParameter;
    }


}
