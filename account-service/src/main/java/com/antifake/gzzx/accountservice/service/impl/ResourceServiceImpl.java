package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.mapper.ResourceDOMapper;
import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.service.ResourceService;
import com.antifake.gzzx.common.model.util.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
