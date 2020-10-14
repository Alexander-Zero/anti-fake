package com.antifake.gzzx.accountservice.conf.authentication;

import com.antifake.gzzx.accountservice.model.vo.ResourceVO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
public class CustomUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken implements RoleIdHolder {

    private List<Long> roleIds;

    public CustomUsernamePasswordAuthenticationToken(Object principal, Object credentials) {
        super(principal, credentials);
    }

    public CustomUsernamePasswordAuthenticationToken(Object principal, List<Long> roleIds, List<ResourceVO> authorities) {
        super(principal, null, authorities);
        this.roleIds = roleIds;
    }

    @Override
    public List<Long> getRoleIds() {
        return this.roleIds;
    }

}
