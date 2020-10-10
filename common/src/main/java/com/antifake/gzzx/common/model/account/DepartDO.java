package com.antifake.gzzx.common.model.account;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Table;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 */
@Getter
@Setter
@Table(name = "t_depart")
public class DepartDO {
    private Long departId;
    private String departName;
}
