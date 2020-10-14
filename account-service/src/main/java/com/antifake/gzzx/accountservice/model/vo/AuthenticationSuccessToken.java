package com.antifake.gzzx.accountservice.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
@Getter
@Setter
public class AuthenticationSuccessToken {
    private String token;
    private List<ResourceVO> menu;
}
