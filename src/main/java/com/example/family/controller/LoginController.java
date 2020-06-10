package com.example.family.controller;


import com.example.family.entity.Passprodect;
import com.example.family.entity.Sysuser;
import com.example.family.service.PassprodectService;
import com.example.family.service.SysuserService;
import com.example.family.utils.JsonWrite;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/*
@description
@anther  Administrator
@creater 2020-03-09 17:15
*/
@Controller
public class LoginController {
    @Resource
    private SysuserService userSearch;
    @Resource
    private PassprodectService passprodectService;


    @RequestMapping("/")
    public String index(HttpSession session) {
        //清空session
        session.removeAttribute("sessioninfo");
        return "login/index";
    }

    @RequestMapping("/login/main")
    @ResponseBody
    public JsonWrite getLoginPage(Sysuser user, HttpSession sessioninfo) {
        return userSearch.selectUserByUsername(user,sessioninfo);
    }

    @RequestMapping("/login/rigst")
    @ResponseBody
    public JsonWrite rigst(Sysuser user) {
        user.setKind(0);
        user.setIsdel(0);
        user.setStatus(1);
        return userSearch.rigst(user);
    }

    @RequestMapping("index")
    public String getIndexPage(HttpSession session){
       Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
       String url = "";
        if(sysuser.getKind()==1){
           //管理员
            url = "manager";
       }else{
           //用户
           url = "student/student";
       }
        return null == sysuser?"login/login":url;
    }

    @RequestMapping("getLoginMsg")
    @ResponseBody
    public JsonWrite getLoginMsg(HttpSession session){
        Sysuser sessioninfo = (Sysuser) session.getAttribute("sessioninfo");
        if(null!=sessioninfo){
            return JsonWrite.CUSTOMIZE("202",true,sessioninfo.getUsername());
        }
        return null;
    }

    @RequestMapping("updataPasswordPage")
    public String updataPassPage(ModelMap modelMap,HttpSession session){
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
        modelMap.put("sysuser",sysuser);
        return "updatapassword";
    }

    @RequestMapping("updatapassword")
    @ResponseBody
    public JsonWrite updatePass(Integer id,String password,HttpSession session){
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
        sysuser.setPassword(password);
        userSearch.updateByPrimaryKey(sysuser);
        return JsonWrite.SUCCESS("修改成功");
    }

    @RequestMapping("setpassprodect")
    public String setPassprodect(ModelMap modelMap,HttpSession session){
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
        Passprodect passprodect = passprodectService.selectByUserid(sysuser.getId());
        Passprodect passprodect1 = new Passprodect();
        if(null==passprodect){
            modelMap.put("passprodect",passprodect1);
        }else{
            modelMap.put("passprodect",passprodect);
        }
        return "student/passprodect";
    }

    @RequestMapping("addPassProdect")
    @ResponseBody
    public void addPassProdect(Passprodect passprodect,HttpSession session){
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
        passprodect.setUserid(sysuser.getId());
        passprodectService.insert(passprodect);
    }

    @RequestMapping("myMsg")
    public String myMsg(ModelMap modelMap,HttpSession session){
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");

        Sysuser sysuser1 = userSearch.selectByPrimaryKey(sysuser.getId());
        modelMap.put("sysuser",sysuser1);

        return "student/mymsg";
    }

    @RequestMapping("updateMyMsg")
    @ResponseBody
    public void updateMyMsg(Sysuser sysuser){
        userSearch.updateByPrimaryKey(sysuser);
    }

    @RequestMapping("forget")
    public String forget(){
        return "forget";
    }
}
