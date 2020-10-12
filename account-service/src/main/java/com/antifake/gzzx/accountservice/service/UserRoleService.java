package com.antifake.gzzx.accountservice.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
@Service
public interface UserRoleService {
    void allocateRole(Long userId, List<Long> roleList);

    List<Long> getRoles(Long userId);
}
