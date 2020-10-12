package com.antifake.gzzx.accountservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@NoArgsConstructor
@AllArgsConstructor
public class RoleResourceDO {

    @Id
    private Long roleResourceId;
    @Column
    private Long roleId;//角色ID
    @Column
    private Long resourceId;//资源ID
}
