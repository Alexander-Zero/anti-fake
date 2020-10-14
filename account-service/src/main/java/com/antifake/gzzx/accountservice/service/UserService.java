package com.antifake.gzzx.accountservice.service;

import com.antifake.gzzx.accountservice.model.UserDO;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
public interface UserService extends UserDetailsService {
    void addUser(UserDO userDO);

    void updateUser(UserDO userDO);

    UserDO selectByUserName(String userName);

    UserDO loadUserByMobile(String mobile);
}
