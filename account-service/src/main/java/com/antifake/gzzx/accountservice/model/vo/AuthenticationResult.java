package com.antifake.gzzx.accountservice.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 * 认证成功后返回Token和菜单信息
 */

@Getter
@Setter
@AllArgsConstructor
public class AuthenticationResult {
    private String token;

    private List<ResourceVO> menu;
}
