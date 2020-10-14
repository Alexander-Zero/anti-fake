package com.antifake.gzzx.accountservice.conf.accessControl;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    private Map<String, Collection<ConfigAttribute>> configAttubuteMap = null;

    private void loadResourceDefine() {
        //todo 加载数据库的所有权限
        Collection<ConfigAttribute> attributes;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        AntPathRequestMatcher matcher;
        String resUrl;
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        //1.加载权限资源数据
        if (configAttubuteMap == null) {
            loadResourceDefine();
        }
        Iterator<String> iterator = configAttubuteMap.keySet().iterator();
        while (iterator.hasNext()) {
            resUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return configAttubuteMap.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}