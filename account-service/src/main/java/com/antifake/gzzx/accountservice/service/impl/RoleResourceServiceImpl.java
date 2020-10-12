package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.RoleResourceDOMapper;
import com.antifake.gzzx.accountservice.model.RoleResourceDO;
import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDOMapper roleResourceDOMapper;

    @Override
    public void allocateResource(Long roleId, List<Long> resourceList) {
        resourceList.forEach(x -> {
            RoleResourceDO roleResourceDO = new RoleResourceDO(IDGenerator.nextId(), roleId, x);
            roleResourceDOMapper.insert(roleResourceDO);
        });

    }
}
