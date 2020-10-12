package com.antifake.gzzx.accountservice.mapper;

import com.antifake.gzzx.accountservice.model.UserDO;
import org.apache.catalina.User;
import tk.mybatis.mapper.common.BaseMapper;
import tk.mybatis.mapper.common.ExampleMapper;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/12
 */
public interface UserDOMapper extends BaseMapper<UserDO>, ExampleMapper<UserDO> {
}
