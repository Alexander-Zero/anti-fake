package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.accountservice.model.UserDO;
import com.antifake.gzzx.accountservice.service.UserService;
import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 * 注册用户
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseResult addUser(@RequestBody UserDO userDO) {
        userService.addUser(userDO);
        return ResponseResult.SUCCESS();
    }


//    @PutMapping
//    public ResponseResult updateUser(@RequestBody UserDO userDO) {
//
//        return ResponseResult.SUCCESS();
//    }

}
