package com.antifake.gzzx.common.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 * 通用返回值
 */
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static ResponseResult SUCCESS() {
        return new ResponseResult(0, "操作成功", null);
    }

    public static <T> ResponseResult SUCCESS(T data) {
        return new ResponseResult(0, "操作成功", data);
    }

}
