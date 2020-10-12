package com.antifake.gzzx.accountservice.service;

import com.antifake.gzzx.accountservice.model.ResourceDO;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
public interface ResourceService {
    void addResource(ResourceDO resourceDO);

    List<ResourceDO> getResourceByIds(List<Long> resourceIds);
}
