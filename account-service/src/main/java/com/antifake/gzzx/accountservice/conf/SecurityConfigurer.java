package com.antifake.gzzx.accountservice.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                .antMatchers("/json/login").permitAll()
//                .antMatchers("/v1/t1").hasAnyAuthority("/v1/p1")
//                .antMatchers("v1/t2").hasAnyAuthority("/v2/p2")
//                .antMatchers("/json/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAt(myAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .formLogin()
//                .loginProcessingUrl("/dologin")
//                .permitAll()
//                .and()
                .csrf().disable();
//        super.configure(http);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    //自定义Json验证 , Post提交
    @Bean
    public JsonAuthenticationFilter myAuthenticationFilter() throws Exception {
        JsonAuthenticationFilter filter = new JsonAuthenticationFilter();
        filter.setAuthenticationManager(super.authenticationManagerBean());
        filter.setFilterProcessesUrl("/json/login");
        filter.setAuthenticationSuccessHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("status", "200");
                map.put("msg", authentication.getPrincipal());
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            }
        });

        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
                response.setContentType("application/json;charset=utf-8");
                PrintWriter out = response.getWriter();
                Map<String, Object> map = new HashMap<>();
                map.put("status", "200");
                map.put("msg", "密码或账号错误!");
                out.write(new ObjectMapper().writeValueAsString(map));
                out.flush();
                out.close();
            }
        });

        return filter;
    }


}
