package com.antifake.gzzx.accountservice.model.vo;

import com.antifake.gzzx.accountservice.model.ResourceDO;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/14
 */
@Getter
@Setter
public class ResourceVO implements GrantedAuthority {
    private Long resourceId;//资源ID
    private String resourceName; //资源名
    private String routeUrl;//路由地址
    private Date createDate;
    private Date updateDate;
    private List<ResourceVO> children;

    @Override
    public String getAuthority() {
        return this.routeUrl;
    }
}
