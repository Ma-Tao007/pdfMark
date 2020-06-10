package com.example.family.service;

import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import com.example.family.entity.Company;

public interface CompanyService {


    int deleteByPrimaryKey(Integer id);

    int insert(Company record);

    int insertSelective(Company record);

    Company selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Company record);

    int updateByPrimaryKey(Company record);

    LayuiPageResult getAllList(PageHelper pageHelper,Company company);

    Boolean selectIsExit(Company company);
}

