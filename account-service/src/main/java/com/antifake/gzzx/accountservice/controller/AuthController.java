package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 * 登录类型:
 * 1.手机+验证码登录
 * 2.手机号+密码登录
 * 3.账号+密码登录
 * 4.邮箱+密码登录
 * 5.忘记密码
 */
@RestController
public class AuthController {

    //登录
    public ResponseResult login() {
        return ResponseResult.SUCCESS();
    }


    //登出
    public ResponseResult logout() {
        return ResponseResult.SUCCESS();
    }

    //注册
    public ResponseResult signUp() {
        return ResponseResult.SUCCESS();
    }

    //忘记密码

}
