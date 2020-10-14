//package com.antifake.gzzx.accountservice.service.impl;
//
//import com.antifake.gzzx.accountservice.exception.MobileNotExistException;
//import com.antifake.gzzx.accountservice.conf.authentication.SmsAuthenticationToken;
//import com.antifake.gzzx.accountservice.model.vo.AuthenticationSuccessToken;
//import com.antifake.gzzx.accountservice.service.MobileLoginService;
//import com.antifake.gzzx.accountservice.service.UserService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Random;
//
///**
// * Author : Zero
// * Version: 1.0.0
// * Date   : 2020/10/14
// */
//public class MobileLoginServiceImpl implements MobileLoginService {
//
//    @Autowired
//    private UserService userService;
//
//
//    private Random random = new Random();
//
//    @Value("${verification.code.length}")
//    private int verificationCodeLength;
//
//    @Override
//    public void sendCode(SmsAuthenticationToken smsAuthenticationToken) {
//
//    }
//
//    @Override
//    public AuthenticationSuccessToken login(SmsAuthenticationToken smsAuthenticationToken) {
//
//        //手机号为空或不存在
//        if (StringUtils.isBlank(smsAuthenticationToken.getMobile()) || smsAuthenticationToken.getMobile().matches(SmsAuthenticationToken.MOBILE_REG)) {
//            throw new MobileNotExistException();
//        }
//        StringBuilder verificationCode = new StringBuilder();
//        for (int i = 0; i < verificationCodeLength; i++) {
//            verificationCode.append(random.nextInt(10));
//        }
//
//        AuthenticationSuccessToken menuAndToken = new AuthenticationSuccessToken();
//        return menuAndToken;
//    }
//
//    private void doSendCode(SmsAuthenticationToken smsAuthenticationToken) {
//
//    }
//
//    private boolean verificationCodeValidate(SmsAuthenticationToken smsAuthenticationToken) {
//        return false;
//    }
//}
