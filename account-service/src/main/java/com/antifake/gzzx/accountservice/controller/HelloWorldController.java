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
    public ResponseResult<String> helloWorld() {
        return ResponseResult.SUCCESS("hello world!");
    }

    @GetMapping("/t1")
    public String t1() {
        return "T1";
    }

    @GetMapping("/t2")
    public String t2() {
        return "T2";
    }

    @GetMapping("/t3")
    public String t3() {
        return "T3";
    }
    @GetMapping("/t4")
    public String t4() {
        return "T4";
    }
    @GetMapping("/t5")
    public String t5() {
        return "T5";
    }
    @GetMapping("/t6")
    public String t6() {
        return "T6";
    }
    @GetMapping("/t7")
    public String t7() {
        return "T7";
    }

    @GetMapping("/t8")
    public String t8() {
        return "T8";
    }

    @GetMapping("/t9")
    public String t9() {
        return "T9";
    }

    @GetMapping("/t10")
    public String t10() {
        return "T10";
    }

}
