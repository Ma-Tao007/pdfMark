package com.example.family.mapper;

import com.example.family.entity.Passprodect;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PassprodectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Passprodect record);

    int insertSelective(Passprodect record);

    Passprodect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passprodect record);

    int updateByPrimaryKey(Passprodect record);

    Passprodect selectByUsername(String username);

    Passprodect selectByUserid(Integer id);
}