package com.example.family.controller;

import com.example.family.dao.SysuserManager;
import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import com.example.family.entity.Passprodect;
import com.example.family.entity.Sysuser;
import com.example.family.mapper.SysuserMapper;
import com.example.family.service.PassprodectService;
import com.example.family.service.SysuserService;
import com.example.family.utils.JsonWrite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("sysuser")
public class SysuserController {
    @Resource
    SysuserService iUserSearch;
    @Resource
    SysuserManager sysuserManager;
    @Resource
    SysuserMapper sysuserMapper;
    @Resource
    PassprodectService passprodectService;

    @RequestMapping("getPage")
    public String getPage(){
        return "sysuser/list";
    }

    @RequestMapping("getList")
    @ResponseBody
    public LayuiPageResult getList(PageHelper pageHelper){
       return iUserSearch.getAllList(pageHelper);
    }

    @RequestMapping("show")
    public String getShowPage(Integer id, ModelMap model){
        Sysuser user = iUserSearch.selectByPrimaryKey(id);
        model.put("sysuser",user);
        return "sysuser/show";
    }

    @RequestMapping("update")
    @ResponseBody
    public void updateStatus(Integer id,Integer status){
        sysuserManager.updateStatus(id,status);
    }

    @ResponseBody
    @RequestMapping("delete")
    public void deleteByKey(Sysuser sysuser){
        sysuserManager.deleteByKey(sysuser);
    }


    @ResponseBody
    @RequestMapping("getUserByUsername")
    public JsonWrite getUserByUsername(Sysuser sysuser){
        //线判断，再去找问题
        Sysuser sysuser1 = sysuserMapper.selectByUsername(sysuser);
        if(null==sysuser1 || sysuser1.getKind()==1){
            return JsonWrite.ERROR("用户名不存在");
        }else{
            //去找问题
            Passprodect passprodect = passprodectService.selectByUserid(sysuser1.getId());
            if(null==passprodect){
                return JsonWrite.ERROR("您没有设置密保信息，请联系管理员找回密码");
            }
            return JsonWrite.SUCCESS(passprodect);
        }
    }

    @RequestMapping("updatePass")
    @ResponseBody
    public void updatePass(Sysuser sysuser){
        Sysuser sysuser1 = sysuserMapper.selectByUsername(sysuser);
        sysuser1.setPassword(sysuser.getPassword());
        iUserSearch.updateByPrimaryKey(sysuser1);
    }

}
