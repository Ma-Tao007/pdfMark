package com.example.family.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
@description
@anther  Administrator
@creater 2020-03-12 17:24
*/
@Controller
@RequestMapping("component")
public class ComponentController {
    @RequestMapping("table/height")
    public String getTableHeight(){
        return "component/table/height";
    }

    @RequestMapping("grid/list")
    public String getGridList(){
        return "component/grid/list";
    }

    @RequestMapping("grid/mobile")
    public String getMobile(){
        return "component/grid/mobile";
    }

    @RequestMapping("grid/mobile_pc")
    public String getMobilePC(){
        return "component/grid/mobile-pc";
    }

    @RequestMapping("grid/all")
    public String getGridAll(){
        return "component/grid/all";
    }

    @RequestMapping("grid/stack")
    public String getGridStack(){
        return "component/grid/stack";
    }

    @RequestMapping("grid/speed-dial")
    public String getGridSpeed(){
        return "component/grid/speed-dial";
    }

    @RequestMapping("button/index")
    public String getButtonIndex(){
        return "component/button/index";
    }

    @RequestMapping("form/group")
    public String getFormGroup(){
        return "component/form/group";
    }

    @RequestMapping("nav/index")
    public String getNavIndex(){
        return "component/nav/index";
    }

    @RequestMapping("tabs/index")
    public String getTabsIndex(){
        return "component/tabs/index";
    }

    @RequestMapping("progress/index")
    public String getProgressIndex(){
        return "component/progress/index";
    }

    @RequestMapping("badge/index")
    public String getBadgeIndex(){
        return "component/badge/index";
    }

    @RequestMapping("timeline/index")
    public String getTimelineIndex(){
        return "component/timeline/index";
    }

    @RequestMapping("anim/index")
    public String getAnimIndex(){
        return "component/anim/index";
    }

    @RequestMapping("layer/list")
    public String getLayerList(){
        return "component/layer/list";
    }

    @RequestMapping("layer/special-demo")
    public String getLayerSpecial(){
        return "component/layer/special-demo";
    }

    @RequestMapping("layer/theme")
    public String getLayerTheme(){
        return "component/layer/theme";
    }

    @RequestMapping("laydate/demo1")
    public String getLayDateDemo1(){
        return "component/laydate/demo1";
    }

    @RequestMapping("laydate/demo2")
    public String getLayDateDemo2(){
        return "component/laydate/demo2";
    }

    @RequestMapping("laydate/theme")
    public String getLayDateTheme(){
        return "component/laydate/theme";
    }

    @RequestMapping("laydate/special-demo")
    public String getLayDateSpecial(){
        return "component/laydate/special-demo";
    }

    @RequestMapping("table/simple")
    public String getTableSimple(){
        return "component/table/simple";
    }
    @RequestMapping("table/auto")
    public String getTableAuto(){
        return "component/table/auto";
    }

    @RequestMapping("table/data")
    public String getTableData(){
        return "component/table/data";
    }

    @RequestMapping("table/tostatic")
    public String getTableTostatic(){
        return "component/table/tostatic";
    }

    @RequestMapping("table/page")
    public String getTablePage(){
        return "component/table/page";
    }

    @RequestMapping("table/resetPage")
    public String getTableResetPage(){
        return "component/table/resetPage";
    }

    @RequestMapping("table/headerTool")
    public String getTableHeaderTool(){
        return "component/table/headerTool";
    }

    @RequestMapping("table/totalRows")
    public String getTableTotalRows(){
        return "component/table/totalRows";
    }


    @RequestMapping("table/checkbox")
    public String getTableCheckBox(){
        return "component/table/checkbox";
    }

    @RequestMapping("table/radio")
    public String getTableRadio(){
        return "component/table/radio";
    }

    @RequestMapping("table/treeTable")
    public String getTableTreeTable(){
        return "component/table/treeTable";
    }

    @RequestMapping("table/cellEdit")
    public String getTableCellEdit(){
        return "component/table/cellEdit";
    }

    @RequestMapping("table/form")
    public String getTableForm(){
        return "component/table/form";
    }

    @RequestMapping("table/style")
    public String getTableStyle(){
        return "component/table/style";
    }

    @RequestMapping("table/operate")
    public String getTableOperate(){
        return "component/table/operate";
    }

    @RequestMapping("table/fixed")
    public String getTableFixed(){
        return "component/table/fixed";
    }

    @RequestMapping("table/cellRow")
    public String getTableCellRow(){
        return "component/table/cellRow";
    }

    @RequestMapping("table/reload")
    public String getTableReload(){
        return "component/table/reload";
    }

    @RequestMapping("table/initSort")
    public String getTableInitSort(){
        return "component/table/initSort";
    }

    @RequestMapping("table/cellEvent")
    public String getTableCellEvent(){
        return "component/table/cellEvent";
    }

    @RequestMapping("table/thead")
    public String getTableThead(){
        return "component/table/thead";
    }
}
