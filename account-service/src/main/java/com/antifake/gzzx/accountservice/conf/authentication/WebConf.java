package com.antifake.gzzx.accountservice.conf.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/13
 * 添加鉴权拦截器
 */

@EnableWebMvc
@Component
public class WebConf implements WebMvcConfigurer {
    @Autowired
    public SimpleAuthrotiesHandler simpleAuthrotiesHandler;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleAuthrotiesHandler).addPathPatterns("/**");
    }
}
