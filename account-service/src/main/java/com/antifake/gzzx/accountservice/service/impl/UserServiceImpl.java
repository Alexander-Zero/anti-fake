package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.UserDOMapper;
import com.antifake.gzzx.accountservice.model.UserDO;
import com.antifake.gzzx.accountservice.service.UserService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;

    @Override
    public void addUser(UserDO userDO) {
        userDO.setUserId(IDGenerator.nextId());
        userDOMapper.insert(userDO);
    }

    @Override
    public void updateUser(UserDO userDO) {
        userDOMapper.updateByPrimaryKey(userDO);
    }
}
