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
 */
@Data
@Table(name = "t_user")
public class UserDO {

    @Id
    private Long userId;//ID
    @Column
    private String nickName;//昵称
    @Column
    private String password;//密码
    @Column
    private Integer gender;//性别1、女 2、男 3、中性
    @Column
    private String userName;//姓名
    @Column
    private String headUrl;//头像地址
    @Column
    private String email;//邮件
    @Column
    private String mobile;//电话
    @Column
    private Integer status; //状态



    @Column
    private String departId;//单位ID
    @Column
    private String sector;//部门
    @Column
    private String jobNumber; //工号
    @Column
    private Date birthDate;//出生日期
    @Column
    private String title;//职称
    @Column
    private String duty;//职责
    @Column


    private Date createDate;
    @Column
    private Date updateDate;
}
