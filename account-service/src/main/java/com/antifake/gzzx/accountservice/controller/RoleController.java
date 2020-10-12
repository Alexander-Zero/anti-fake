package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.accountservice.model.RoleDO;
import com.antifake.gzzx.accountservice.service.RoleService;
import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public ResponseResult addRole(@RequestBody RoleDO roleDO) {
        roleService.addRole(roleDO);
        return ResponseResult.SUCCESS();
    }


}
