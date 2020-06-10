package com.example.family.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
@description
@anther  Administrator
@creater 2020-03-12 14:52
*/
@Controller
@RequestMapping("home")
public class HomeController {
    @RequestMapping("console")
    public String getConsole(){
        return "home/console";
    }

    @RequestMapping("homepage1")
    public String getHomePageOne(){
        return "home/homepage1";
    }

    @RequestMapping("homepage2")
    public String getHomePageTwo(){
        return "home/homepage2";
    }
}
