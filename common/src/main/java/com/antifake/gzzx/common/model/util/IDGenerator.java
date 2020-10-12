package com.antifake.gzzx.common.model.util;

import cn.hutool.core.lang.Snowflake;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
public class IDGenerator {

    private static Snowflake SNOW_FLAKE = new Snowflake(1, 1);

    public static Long nextId() {
        return SNOW_FLAKE.nextId();
    }
}
