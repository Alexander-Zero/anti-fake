package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.UserDOMapper;
import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.model.UserDO;
import com.antifake.gzzx.accountservice.model.vo.ResourceVO;
import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.accountservice.service.UserRoleService;
import com.antifake.gzzx.accountservice.service.UserService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private RoleResourceService roleResourceService;

    @Override
    public void addUser(UserDO userDO) {
        UserDO dbUserDO = selectByUserName(userDO.getUserName());
        if (dbUserDO != null) {
            throw new RuntimeException("用户已存在");
        }


        userDO.setUserId(IDGenerator.nextId());
        userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
        userDOMapper.insert(userDO);
    }

    @Override
    public void updateUser(UserDO userDO) {
        UserDO dbUserDO = selectByUserName(userDO.getUserName());
        userDO.setPassword(passwordEncoder.encode(userDO.getPassword()));
        userDO.setUserId(dbUserDO.getUserId());
        userDOMapper.updateByPrimaryKey(userDO);
    }

    @Override
    public UserDO selectByUserName(String userName) {
        Example example = new Example(UserDO.class);
        example.createCriteria()
                .andEqualTo("userName", userName);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (userDOS.size() > 0) {
            return userDOS.get(0);
        }
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDO userDO = selectByUserName(s);
        if (userDO == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        List<Long> roleIds = userRoleService.getRoles(userDO.getUserId());
        List<ResourceVO> resource = roleResourceService.getResource(roleIds);
        return new User(userDO.getUserName(), userDO.getPassword(), resource);
    }

    @Override
    public UserDO loadUserByMobile(String mobile) {
        return null;
    }
}
