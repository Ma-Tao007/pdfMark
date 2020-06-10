package com.example.family.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.example.family.mapper.PassprodectMapper;
import com.example.family.entity.Passprodect;
import com.example.family.service.PassprodectService;

@Service
public class PassprodectServiceImpl implements PassprodectService {

    @Resource
    private PassprodectMapper passprodectMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return passprodectMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Passprodect record) {
        return passprodectMapper.insert(record);
    }

    @Override
    public int insertSelective(Passprodect record) {
        return passprodectMapper.insertSelective(record);
    }

    @Override
    public Passprodect selectByPrimaryKey(Integer id) {
        return passprodectMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Passprodect record) {
        return passprodectMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Passprodect record) {
        return passprodectMapper.updateByPrimaryKey(record);
    }

    @Override
    public Passprodect selectByUsername(String username) {
        return passprodectMapper.selectByUsername(username);
    }

    @Override
    public Passprodect selectByUserid(Integer id) {
        return passprodectMapper.selectByUserid(id);
    }

}

