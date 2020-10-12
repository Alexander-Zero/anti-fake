//package com.antifake.gzzx.accountservice.conf;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StreamUtils;
//import org.springframework.util.StringUtils;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//@Component
//public class MyUserPasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
//
//    public MyUserPasswordAuthenticationFilter() {
//        super(new AntPathRequestMatcher("/login", "POST"));
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
//        //从json中获取username和password
//        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), Charset.forName("UTF-8"));
//        String username = null, password = null;
//        if (StringUtils.hasText(body)) {
//            JSONObject jsonObj = JSON.parseObject(body);
//            username = jsonObj.getString("username");
//            password = jsonObj.getString("password");
//        }
//
//        if (username == null)
//            username = "";
//        if (password == null)
//            password = "";
//        username = username.trim();
//        //封装到token中提交
//        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
//
//        return this.getAuthenticationManager().authenticate(authRequest);
//    }
//}
