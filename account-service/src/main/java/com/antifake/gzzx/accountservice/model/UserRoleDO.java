package com.antifake.gzzx.accountservice.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@Setter
@Getter
@Table(name = "r_user_role")
public class UserRoleDO {

    @Id
    private Long userRoleId;
    @Column
    private Long userId;//用户ID
    @Column
    private Long roleId;//角色ID
}
