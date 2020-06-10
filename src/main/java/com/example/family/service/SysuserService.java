package com.example.family.service;

import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import com.example.family.entity.Sysuser;
import com.example.family.utils.JsonWrite;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface SysuserService {


    int deleteByPrimaryKey(Integer id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

    LayuiPageResult getAllList(PageHelper pageHelper);

    JsonWrite selectUserByUsername(Sysuser user, HttpSession session);

    JsonWrite rigst(Sysuser user);
}




