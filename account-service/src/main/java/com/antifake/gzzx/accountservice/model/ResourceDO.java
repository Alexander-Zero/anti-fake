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
@Table(name = "t_resource")
public class ResourceDO {
    @Id
    private String resourceId;//资源ID
    @Column
    private String resourceName; //资源名
    @Column
    private String parentId;   //父ID
    @Column
    private String resourceDesc;//资源描述
    @Column
    private String routerUrl;//路由地址
    @Column
    private String resourceIcon;//资源图标
    @Column
    private Integer resourceType;//资源类型[0菜单/1按钮/2路由]
    @Column
    private Integer status;
    @Column
    private Integer resourceLevel;//资源等级
    @Column
    private Integer serialNumber; //序号
    @Column
    private Date createDate;
    @Column
    private Date updateDate;

}
