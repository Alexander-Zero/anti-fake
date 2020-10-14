package com.antifake.gzzx.accountservice.conf.accessControl;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Iterator;

@Component
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        ConfigAttribute c;
        String needRole;
        if(null== configAttributes || configAttributes.size() <=0) {
            return;
        }
        //1.获取已定义的好资源权限配置
        Iterator<ConfigAttribute> iterable=configAttributes.iterator();
        while (iterable.hasNext()){
            c=iterable.next();
            needRole=c.getAttribute();
            //2.依次比对用户角色对应的资源权限
            for (GrantedAuthority grantedAuthority:authentication.getAuthorities()){
                if(needRole.trim().equals(grantedAuthority.getAuthority())){
                    return;
                }
            }
        }

    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}