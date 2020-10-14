package com.antifake.gzzx.accountservice.conf.authentication;

import com.antifake.gzzx.accountservice.model.UserDO;
import com.antifake.gzzx.accountservice.model.vo.ResourceVO;
import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.accountservice.service.UserRoleService;
import com.antifake.gzzx.accountservice.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 * 备注: 无法使用@autowired注解, 需实现applicationContextAware接口
 */
public class DBAuthenticationProvider implements AuthenticationProvider, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private UserService userService() {
        return applicationContext.getBean(UserService.class);
    }


    private UserRoleService userRoleService() {
        return applicationContext.getBean(UserRoleService.class);
    }

    private RoleResourceService roleResourceService() {
        return applicationContext.getBean(RoleResourceService.class);
    }

    private PasswordEncoder passwordEncoder() {
        return applicationContext.getBean(PasswordEncoder.class);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CustomUsernamePasswordAuthenticationToken authenticationToken = (CustomUsernamePasswordAuthenticationToken) authentication;
        String username = (String) authenticationToken.getPrincipal();
        String password = (String) authenticationToken.getCredentials();
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new BadCredentialsException("用户名或密码为空!");
        }
        UserDO userDO = userService().selectByUserName(username);
        if (userDO == null) {
            throw new BadCredentialsException("用户不存在");
        }

        if (!passwordEncoder().matches(password, userDO.getPassword())) {
            throw new BadCredentialsException("密码错误");
        }

        List<Long> roles = userRoleService().getRoles(userDO.getUserId());
        List<ResourceVO> authorities = roleResourceService().getResource(roles);

        return new CustomUsernamePasswordAuthenticationToken(userDO, roles, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return CustomUsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
