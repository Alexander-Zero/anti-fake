package com.antifake.gzzx.accountservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@Getter
@Setter
@Table(name = "t_role")
public class RoleDO {

    @Id
    private Long roleId;//ID
    @Column
    private String roleName;//角色名
    @Column
    private String roleDesc;//角色描述
    @Column
    private Integer status;//状态

    @Column
    private Date createDate;
    @Column
    private Date updateDate;
}
