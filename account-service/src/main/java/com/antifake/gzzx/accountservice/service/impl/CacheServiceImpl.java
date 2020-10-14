package com.antifake.gzzx.accountservice.service.impl;

import com.antifake.gzzx.accountservice.service.CacheService;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
@Service
public class CacheServiceImpl implements CacheService {
    private ConcurrentMap<String, Map.Entry<String, Date>> verificationCodeMap = new ConcurrentHashMap<>();

    @Override
    public Map.Entry<String, Date> getSmsCode(String mobile) {
        return verificationCodeMap.get(mobile);
    }

    @Override
    public void putVerificationCode(String mobile, String verificationCode) {
        verificationCodeMap.put(mobile, new AbstractMap.SimpleEntry<>(verificationCode, new Date()));
    }
}
