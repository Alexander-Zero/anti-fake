package com.antifake.gzzx.accountservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@Data
@Table(name = "r_role_resource")
public class RoleResourceDO {

    @Id
    private String roleResourceId;
    @Column
    private String roleId;//角色ID
    @Column
    private String resourceId;//资源ID
}
