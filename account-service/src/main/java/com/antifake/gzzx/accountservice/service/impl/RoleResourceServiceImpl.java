package com.antifake.gzzx.accountservice.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.antifake.gzzx.accountservice.mapper.RoleResourceDOMapper;
import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.model.RoleResourceDO;
import com.antifake.gzzx.accountservice.service.ResourceService;
import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public class RoleResourceServiceImpl implements RoleResourceService {

    @Autowired
    private RoleResourceDOMapper roleResourceDOMapper;
    @Autowired
    private ResourceService resourceService;

    @Override
    public void allocateResource(Long roleId, List<Long> resourceList) {
        resourceList.forEach(x -> {
            RoleResourceDO roleResourceDO = new RoleResourceDO(IDGenerator.nextId(), roleId, x);
            roleResourceDOMapper.insert(roleResourceDO);
        });

    }


    @Override
    public List<ResourceDO> getResource(List<Long> roleIds) {
        if (CollectionUtil.isEmpty(roleIds)) {
            return Collections.emptyList();
        }
        Example example = new Example(RoleResourceDO.class);
        example.createCriteria()
                .andIn("roleId", roleIds);
        List<RoleResourceDO> roleResourceDOS = roleResourceDOMapper.selectByExample(example);
        List<Long> resourceIds = roleResourceDOS.stream()
                .map(RoleResourceDO::getResourceId)
                .collect(Collectors.toList());
        List<ResourceDO> resources = resourceService.getResourceByIds(resourceIds);
        return resources;
    }
}
