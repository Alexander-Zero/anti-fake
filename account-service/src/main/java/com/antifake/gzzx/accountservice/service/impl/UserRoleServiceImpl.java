package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.UserRoleDOMapper;
import com.antifake.gzzx.accountservice.model.UserRoleDO;
import com.antifake.gzzx.accountservice.service.UserRoleService;
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
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDOMapper userRoleDOMapper;

    @Override
    public void allocateRole(Long userId, List<Long> roleList) {
//        List<UserRoleDO> userRoleDOList = new ArrayList<>(roleList.size());

        roleList.forEach(x -> {
            UserRoleDO userRoleDO = new UserRoleDO(IDGenerator.nextId(), userId, x);
            userRoleDOMapper.insert(userRoleDO);
//            userRoleDOList.add(userRoleDO);
        });

    }
}
