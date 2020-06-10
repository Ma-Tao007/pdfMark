package com.example.family.service.impl;

import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import com.example.family.utils.JsonWrite;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.example.family.mapper.SysuserMapper;
import com.example.family.entity.Sysuser;
import com.example.family.service.SysuserService;

import java.util.List;

@Service
public class SysuserServiceImpl implements SysuserService {

    @Resource
    private SysuserMapper sysuserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysuserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sysuser record) {
        return sysuserMapper.insert(record);
    }

    @Override
    public int insertSelective(Sysuser record) {
        return sysuserMapper.insertSelective(record);
    }

    @Override
    public Sysuser selectByPrimaryKey(Integer id) {
        return sysuserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sysuser record) {
        return sysuserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sysuser record) {
        return sysuserMapper.updateByPrimaryKey(record);
    }

    @Override
    public LayuiPageResult getAllList(PageHelper pageHelper) {
        LayuiPageResult layuiPageResult = new LayuiPageResult();
        layuiPageResult.setCount(sysuserMapper.getCount());
        layuiPageResult.setData(sysuserMapper.getAllList(pageHelper));
        return layuiPageResult;
    }

    @Override
    public JsonWrite selectUserByUsername(Sysuser user, HttpSession session) {
        Sysuser sysuser = sysuserMapper.selectByUsername(user);
        if(null == sysuser){
           return JsonWrite.CUSTOMIZE("401",false,"用户名不存在");
        }
        if(!user.getPassword().equals(sysuser.getPassword())){
            return JsonWrite.CUSTOMIZE("403",false,"密码错误");
        }
        if(sysuser.getStatus()==0){
            return JsonWrite.ERROR("账号被禁用，无法登录");
        }
        //验证成功保存到session中
        session.setAttribute("sessioninfo",sysuser);

        return JsonWrite.CUSTOMIZE("200",true,"验证成功");
    }

    @Override
    public JsonWrite rigst(Sysuser user) {
        Sysuser sysuser = sysuserMapper.selectByUsername(user);
        if(null==sysuser){
            return JsonWrite.SUCCESS(sysuserMapper.insert(user));
        }else{
            return JsonWrite.ERROR("用户名已存在");
        }
    }

}




