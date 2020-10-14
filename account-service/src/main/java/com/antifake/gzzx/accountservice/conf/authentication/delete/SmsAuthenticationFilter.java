//package com.antifake.gzzx.accountservice.conf.authentication;
//
//import org.springframework.security.authentication.AuthenticationServiceException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.util.Assert;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Author : Zero
// * Version: 1.0.0
// * Date   : 2020/10/14
// */
//public class SmsAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    public static final String SPRING_SECURITY_FORM_MOBILE_KEY = "mobile";
//
//    private String mobileParameter = SPRING_SECURITY_FORM_MOBILE_KEY;
//
//    public SmsAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/sms/login", "POST"));
//    }
//
//    private boolean postOnly = true;
//
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
//        if (postOnly && !request.getMethod().equals("POST")) {
//            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
//        }
//
//        String mobile = obtainMobile(request);
//
//        if (mobile == null) {
//            mobile = "";
//        }
//
//        mobile = mobile.trim();
//
//        SmsAuthenticationToken authRequest = new SmsAuthenticationToken(mobile);
//
//        // Allow subclasses to set the "details" property
//        setDetails(request, authRequest);
//
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//
//    protected String obtainMobile(HttpServletRequest request) {
//        return request.getParameter(mobileParameter);
//    }
//
//    protected void setDetails(HttpServletRequest request, SmsAuthenticationToken authRequest) {
//        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
//    }
//
//    public String getMobileParameter() {
//        return mobileParameter;
//    }
//
//    public void setMobileParameter(String mobileParameter) {
//        Assert.hasText(mobileParameter, "Mobile parameter must not be empty or null");
//        this.mobileParameter = mobileParameter;
//    }
//
//    public void setPostOnly(boolean postOnly) {
//        this.postOnly = postOnly;
//    }
//}
