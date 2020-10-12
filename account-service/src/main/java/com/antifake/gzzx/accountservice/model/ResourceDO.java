package com.antifake.gzzx.accountservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

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
public class ResourceDO implements GrantedAuthority {
    @Id
    private Long resourceId;//资源ID
    @Column
    private String resourceName; //资源名
    @Column
    private String routeUrl;//路由地址
    @Column
    private Long parentId;   //父ID
    @Column
    private Date createDate;
    @Column
    private Date updateDate;

    @Override
    public String getAuthority() {
        return this.routeUrl;
    }
}
