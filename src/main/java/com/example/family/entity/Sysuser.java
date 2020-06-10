package com.example.family.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sysuser {
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户类型（0 管理员 1学生）
     */
    private Integer kind;

    /**
     * 姓名
     */
    private String persname;

    /**
     * 性别
     */
    private String sex;

    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date birthday;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 学历
     */
    private String qualiy;

    /**
     * 技能
     */
    private String skill;

    /**
     * 所学专业
     */
    private String major;

    /**
     * 是否删除（0 否 1 是）
     */
    private Integer isdel;

    /**
     * 状态（0 禁用 1启用）
     */
    private Integer status;

    /**
     * 自我介绍
     */
    private String remark;
}