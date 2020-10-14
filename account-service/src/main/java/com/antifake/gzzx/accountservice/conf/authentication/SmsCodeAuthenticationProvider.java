package com.antifake.gzzx.accountservice.conf.authentication;

import com.antifake.gzzx.accountservice.model.UserDO;
import com.antifake.gzzx.accountservice.model.vo.ResourceVO;
import com.antifake.gzzx.accountservice.service.CacheService;
import com.antifake.gzzx.accountservice.service.RoleResourceService;
import com.antifake.gzzx.accountservice.service.UserRoleService;
import com.antifake.gzzx.accountservice.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 * 短信认证
 * 备注: 无法使用@autowired注解, 需实现applicationContextAware接口
 */

public class SmsCodeAuthenticationProvider implements AuthenticationProvider, ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    private CacheService cacheService() {
        return applicationContext.getBean(CacheService.class);
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

    @Value("${verification.code.expire.time}")
    private int expiredTime;

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;

        String mobile = (String) authenticationToken.getPrincipal();
        String smsCode = (String) authenticationToken.getCredentials();

        checkSmsCode(mobile, smsCode);

        UserDO userDO = userService().loadUserByMobile(mobile);//用户
        List<Long> roleIds = userRoleService().getRoles(userDO.getUserId());//角色
        List<ResourceVO> authorities = roleResourceService().getResource(roleIds);//权限

        // 此时鉴权成功后，应当重新 new 一个拥有鉴权的 authenticationResult 返回
        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(userDO, roleIds, authorities);

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    private void checkSmsCode(String mobile, String smsCode) {
        if (StringUtils.isBlank(mobile) || StringUtils.isBlank(smsCode)) {
            throw new BadCredentialsException("验证码或手机号错误!");
        }
        Map.Entry<String, Date> smsCodeEntry = cacheService().getSmsCode(mobile);
        if (smsCodeEntry == null) {
            throw new BadCredentialsException("验证码或手机号错误!");
        }
        String cacheSmsCode = smsCodeEntry.getKey();
        if (StringUtils.isBlank(cacheSmsCode) || !cacheSmsCode.equals(smsCode)) {
            throw new BadCredentialsException("验证码或手机号错误!");
        }
        if (smsCodeEntry.getValue() == null || (new Date().getTime() - smsCodeEntry.getValue().getTime() > expiredTime * 1000)) {
            throw new CredentialsExpiredException("验证码已过期");
        }
    }


//    public UserDetailsService getUserDetailsService() {
//        return userDetailsService;
//    }
//
//    public void setUserDetailsService(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }

}
