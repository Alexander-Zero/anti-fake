package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@RestController
@RequestMapping("/v1")
public class HelloWorldController {

    @GetMapping("/hi")
    public ResponseResult helloWorld() {
        return ResponseResult.SUCCESS("hello world!");
    }
}
