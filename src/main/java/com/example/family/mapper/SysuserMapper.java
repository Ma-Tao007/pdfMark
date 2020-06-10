package com.example.family.mapper;

import com.example.family.dto.PageHelper;
import com.example.family.entity.Sysuser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sysuser record);

    int insertSelective(Sysuser record);

    Sysuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sysuser record);

    int updateByPrimaryKey(Sysuser record);

    Sysuser selectByUsername(Sysuser user);

    int getCount();

    List<Sysuser> getAllList(PageHelper pageHelper);

    void updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}