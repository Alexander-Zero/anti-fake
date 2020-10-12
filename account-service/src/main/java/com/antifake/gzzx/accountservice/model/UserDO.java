package com.antifake.gzzx.accountservice.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Author : Zero
 * Version: 1.0.0
 * Date   : 2020/10/10
 * zero: admin (p1-p5)
 * alex: client(p6-p10)
 * alexander: admin+client (p1-p10)
 */
@Data
@Table(name = "t_user")
public class UserDO {

    @Id
    private Long userId;//ID
    @Column
    private String userName;//姓名
    @Column
    private String password;//密码
    @Column
    private String nickName;//昵称
    @Column
    private Integer gender;//性别1、女 2、男 3、中性
    @Column
    private String headUrl;//头像地址
    @Column
    private String email;//邮件
    @Column
    private String mobile;//电话
    @Column
    private Integer status; //状态

    @Column
    private Date createDate;
    @Column
    private Date updateDate;
}
