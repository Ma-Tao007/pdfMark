package com.example.family.dao.impl;

import com.example.family.dao.SysuserManager;
import com.example.family.entity.Sysuser;
import com.example.family.mapper.SysuserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/*
@description
@anther  Administrator
@creater 2020-03-10 15:00
*/
//业务层  事务
@Service
@Transactional
public class SysuserManagerImpl implements SysuserManager {
    @Resource
    SysuserMapper sysuserMapper;

    @Override
    public void updateStatus(Integer id, Integer status) {
        sysuserMapper.updateStatus(id,status);
    }

    @Override
    public void deleteByKey(Sysuser sysuser) {
        sysuserMapper.deleteByPrimaryKey(sysuser.getId());
    }
}
