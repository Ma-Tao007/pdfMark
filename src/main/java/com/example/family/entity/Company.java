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
public class Company {
    /**
     * 企业管理
     */
    private Integer id;

    /**
     * 企业编码
     */
    private String companyno;

    /**
     * 企业名称
     */
    private String companyname;

    /**
     * 招聘职位
     */
    private String post;

    /**
     * 企业地址
     */
    private String location;

    /**
     * 招聘负责人
     */
    private String people;

    /**
     * 联系方式
     */
    private String peoplephone;

    /**
     * 发布时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    private Date date;

    /**
     * 面试方式
     */
    private String type;

    /**
     * 所需学历
     */
    private String qualiy;

    /**
     * 薪资代码
     */
    private String money;

    private Integer isdel;
}