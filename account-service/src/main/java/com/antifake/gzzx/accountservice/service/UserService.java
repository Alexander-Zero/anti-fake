package com.antifake.gzzx.accountservice.service;

import com.antifake.gzzx.accountservice.model.UserDO;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
public interface UserService {
    void addUser(UserDO userDO);
    void updateUser(UserDO userDO);
}
