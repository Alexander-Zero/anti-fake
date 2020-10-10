package com.antifake.gzzx.common.model.account;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 * 状态常量: 有效,无效,新增,删除,更新, 激活,冻结
 */
public class StatusConstant {
    public static final int VALID= 1;//有效
    public static final int INVALID = 0;//无效

    public static final int ACTIVATED = 2;//激活
    public static final int FROZE= 3;//冻结

    public static final int NEW= 4;//新增
    public static final int UPDATE= 5;//更新
    public static final int DELETE= 6;//逻辑删除
}
