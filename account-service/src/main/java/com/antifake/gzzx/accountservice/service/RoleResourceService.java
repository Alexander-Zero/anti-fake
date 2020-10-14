package com.antifake.gzzx.accountservice.service;

import com.antifake.gzzx.accountservice.model.ResourceDO;
import com.antifake.gzzx.accountservice.model.vo.ResourceVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public interface RoleResourceService {
    void allocateResource(Long roleId, List<Long> resourceList);

    List<ResourceVO> getResource(List<Long> roleIds);
}
