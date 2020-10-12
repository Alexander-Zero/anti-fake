package com.antifake.gzzx.accountservice.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.antifake.gzzx.accountservice.mapper.ResourceDOMapper;
import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.service.ResourceService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Collections;
import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDOMapper resourceDOMapper;

    @Override
    public void addResource(ResourceDO resourceDO) {
        resourceDO.setResourceId(IDGenerator.nextId());
        resourceDOMapper.insert(resourceDO);
    }

    @Override
    public List<ResourceDO> getResourceByIds(List<Long> resourceIds) {
        if (CollectionUtil.isEmpty(resourceIds)) {
            return Collections.emptyList();
        }
        Example example = new Example(ResourceDO.class);
        example.createCriteria()
                .andIn("resourceId", resourceIds);
        return resourceDOMapper.selectByExample(example);
    }
}
