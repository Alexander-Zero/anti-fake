package com.antifake.gzzx.accountservice.controller;

import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.service.ResourceService;
import com.antifake.gzzx.common.model.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@RestController
@RequestMapping("/resource")
public class ResourceController {
    @Autowired
    private ResourceService resourceService;

    public ResponseResult addResource(@RequestBody ResourceDO resourceDO) {
        resourceService.addResource(resourceDO);
        return ResponseResult.SUCCESS();
    }

}
