package com.example.family.service;

import com.example.family.entity.Passprodect;

public interface PassprodectService {


    int deleteByPrimaryKey(Integer id);

    int insert(Passprodect record);

    int insertSelective(Passprodect record);

    Passprodect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Passprodect record);

    int updateByPrimaryKey(Passprodect record);

    Passprodect selectByUsername(String username);

    Passprodect selectByUserid(Integer id);
}

