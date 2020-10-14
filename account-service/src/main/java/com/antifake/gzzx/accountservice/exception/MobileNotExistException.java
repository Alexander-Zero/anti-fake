package com.antifake.gzzx.accountservice.exception;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 * 手机号不存在
 */
public class MobileNotExistException extends RuntimeException {
    public MobileNotExistException() {
        super("手机号不存在");
    }
}
