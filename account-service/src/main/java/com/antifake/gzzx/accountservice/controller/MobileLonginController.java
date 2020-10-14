//package com.antifake.gzzx.accountservice.controller;
//
//import com.antifake.gzzx.accountservice.conf.authentication.SmsAuthenticationToken;
//import com.antifake.gzzx.accountservice.model.vo.AuthenticationSuccessToken;
//import com.antifake.gzzx.accountservice.service.MobileLoginService;
//import com.antifake.gzzx.common.model.ResponseResult;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
///**
// * Author : Zero
// * Version: 1.0.0
// * Date   : 2020/10/14
// * 手机登录验证
// */
//@RestController
//@RequestMapping("/mobile")
//public class MobileLonginController {
//
//    @Autowired
//    private MobileLoginService mobileLoginService;
//
//    @GetMapping("/code")
//    public ResponseResult sendCode(@RequestBody SmsAuthenticationToken smsAuthenticationToken) {
//        mobileLoginService.sendCode(smsAuthenticationToken);
//        return ResponseResult.SUCCESS();
//    }
//
//    @PostMapping("/login")
//    public ResponseResult login(@RequestBody SmsAuthenticationToken smsAuthenticationToken) {
//        AuthenticationSuccessToken menuAndToken = mobileLoginService.login(smsAuthenticationToken);
//        return ResponseResult.SUCCESS(menuAndToken);
//    }
//
//}
