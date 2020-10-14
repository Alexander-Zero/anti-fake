package com.antifake.gzzx.accountservice.service;

import java.util.Date;
import java.util.Map;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
public interface CacheService {
    Map.Entry<String, Date> getSmsCode(String mobile);

    void putVerificationCode(String mobile, String verificationCode);
}
