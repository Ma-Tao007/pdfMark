package com.example.family.controller;

import com.example.family.dto.ConfigProperties;
import com.example.family.dto.LayuiPageResult;
import com.example.family.dto.PageHelper;
import com.example.family.entity.Company;
import com.example.family.entity.Sysuser;
import com.example.family.service.CompanyService;
import com.example.family.utils.JsonWrite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("company")
public class CompanyController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);
    @Autowired
    private ConfigProperties configProperties;
    @Resource
    CompanyService companyService;

    @RequestMapping("getPage")
    public String getPage(HttpSession session) {
        Sysuser sysuser = (Sysuser)session.getAttribute("sessioninfo");
        String url = "";
        //1是管理员
        if(sysuser.getKind()==1){
            url = "company/list";
        }else{
            url = "student/company";
        }
        return url;
    }

    @RequestMapping("getList")
    @ResponseBody
    public LayuiPageResult getList(PageHelper pageHelper,Company company){

        return companyService.getAllList(pageHelper,company);
    }

    @RequestMapping("show")
    public String getShowPage(Integer id,Integer type, ModelMap model){
        Company company = companyService.selectByPrimaryKey(id);
        model.put("company",company);
        return type==0?"company/show":"company/updata";
    }

    @RequestMapping("updata")
    @ResponseBody
    public JsonWrite updateStatus(Company company){
        //查看企业编码不可重复
        Boolean isexit = companyService.selectIsExit(company);
        if(!isexit){
            companyService.updateByPrimaryKey(company);
            return JsonWrite.SUCCESS("编辑成功");
        }
        return JsonWrite.ERROR("企业编码已存在");
    }

    @RequestMapping("addPage")
    public String getAddPage( ModelMap model){
        model.put("company",new Company());
        return "company/add";
    }

    @RequestMapping("add")
    @ResponseBody
    public JsonWrite add(Company company){
        //查看企业编码不可重复
        Boolean isexit = companyService.selectIsExit(company);
        if(!isexit){
            companyService.insert(company);
            return JsonWrite.SUCCESS("编辑成功");
        }
        return JsonWrite.ERROR("企业编码已存在");
    }

    @RequestMapping("getUser")
    @ResponseBody
    public JsonWrite getUser(HttpSession session){
        //查看企业编码不可重复
        Sysuser sysuser = (Sysuser) session.getAttribute("sessioninfo");
        return JsonWrite.SUCCESS(sysuser);
    }

    //文件上传
    @RequestMapping("upload")
    @ResponseBody
    public JsonWrite upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return JsonWrite.ERROR("上传失败，请选择文件");
        }
        //获取上传的文件名
        String fileName = file.getOriginalFilename();
        //这里我们需要判断文件类型
        /* 获取文件前缀 判断是否是pdf，如果不是需要将其转为pdf */
        String suffix = fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        //获取配置文件中的上传文件的本地地址
        String filePath = configProperties.getPdfloadPath();
        //获取一个随机数
        String uuid= UUID.randomUUID()+"";
        File dest = new File(filePath +uuid+ fileName);
        try {
            //创建文件，是否存在父文件夹，不存在则创建后插入
            File fileParent = dest.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }
            dest.createNewFile();
            //文件内容写入
            file.transferTo(dest);
            LOGGER.info(filePath+dest.getName()+"上传成功");
            return JsonWrite.SUCCESS("上传成功");
        } catch (IOException e) {
            LOGGER.error("上传文件出现异常,异常信息：",e);
        }
        return  JsonWrite.ERROR("上传失败");
    }
}
