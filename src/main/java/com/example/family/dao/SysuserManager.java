package com.example.family.dao;

import com.example.family.entity.Sysuser;

/*
@description
@anther  Administrator
@creater 2020-03-10 14:59
*/
public interface SysuserManager {
    void updateStatus(Integer id, Integer status);

    void deleteByKey(Sysuser sysuser);
}
