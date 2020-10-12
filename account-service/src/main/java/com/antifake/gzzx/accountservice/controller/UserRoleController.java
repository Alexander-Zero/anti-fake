package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.accountservice.service.UserRoleService;
import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.POST;
import java.util.List;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */

@RestController
@RequestMapping("/userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping
    public ResponseResult allocateRole(@RequestBody Map<String, Object> param) {
        long userId = (long)param.get("userId");
        List<Long> roleIds =(List<Long>) param.get("roleId");
        userRoleService.allocateRole(userId,roleIds);
        return ResponseResult.SUCCESS();
    }

}
