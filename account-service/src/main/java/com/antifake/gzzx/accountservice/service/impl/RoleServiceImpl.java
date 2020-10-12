package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.RoleDOMapper;
import com.antifake.gzzx.accountservice.model.RoleDO;
import com.antifake.gzzx.accountservice.service.RoleService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDOMapper roleDOMapper;


    @Override
    public void addRole(RoleDO roleDO) {
        roleDO.setRoleId(IDGenerator.nextId());
        roleDOMapper.insert(roleDO);
    }
}
