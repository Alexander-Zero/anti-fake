package com.antifake.gzzx.accountservice.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

import java.util.Calendar;
import java.util.Date;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
public class JwtUtil {
    /**
     * 密钥，仅服务端存储
     */
    private static String secret = "ko346134h_we]rg3in_yip1!";
    private static final Integer LONGEST_EXP_HOURS = 24;
    private static final Integer DEFAULT_EXP_HOURS = 1;

    /**
     * @param subject
     * @param issueDate 签发时间
     * @return
     */
    public static String createToken(String subject, boolean rememberMe) {
        Date issueDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(issueDate);
        c.add(Calendar.HOUR, getExpHours(rememberMe));

        String token = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(issueDate)
                .setExpiration(c.getTime())

                .signWith(io.jsonwebtoken.SignatureAlgorithm.HS512, secret)
                .compact();
        return token;
    }

    /**
     * 解密 jwt
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static String parseToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private static Integer getExpHours(boolean rememberMe) {
        return rememberMe ? LONGEST_EXP_HOURS : DEFAULT_EXP_HOURS;
    }
}