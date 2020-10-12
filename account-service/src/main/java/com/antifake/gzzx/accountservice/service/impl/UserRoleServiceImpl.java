package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.UserRoleDOMapper;
import com.antifake.gzzx.accountservice.model.UserRoleDO;
import com.antifake.gzzx.accountservice.service.UserRoleService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<Long> getRoles(Long userId) {
        Example example = new Example(UserRoleDO.class);
        example.createCriteria()
                .andEqualTo("userId", userId);
        List<UserRoleDO> userRoleDOS = userRoleDOMapper.selectByExample(example);
        List<Long> collect = userRoleDOS.stream()
                .map(UserRoleDO::getRoleId)
                .collect(Collectors.toList());
        return collect;
    }
}
