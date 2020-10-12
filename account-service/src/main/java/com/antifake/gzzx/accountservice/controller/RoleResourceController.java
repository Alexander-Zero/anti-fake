package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */

@RestController
@RequestMapping("/roleResource")
public class RoleResourceController {
    @Autowired
    private RoleResourceService roleResourceService;

    @PostMapping
    public ResponseResult allocateResource(@RequestBody Map<String, Object> param) {
        long roleId = (long) param.get("roleId");
        List<Long> resourceIds = (List<Long>) param.get("resourceId");
        roleResourceService.allocateResource(roleId, resourceIds);
        return ResponseResult.SUCCESS();
    }

}
