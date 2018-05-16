package com.it.bos.controller;/**
 * Created by Think on 2018/5/8.
 */

import com.it.bos.pojo.BcStaff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @ClassName MenuController
 * @Description 菜单页面的跳转controller
 * @Author Think
 * @Date 2018/5/8 1:41
 * @Version 1.0
 */
@Controller
public class MenuController {

    @RequestMapping("/page_common_home")
    public String findMessage(){
        return "portal/gonggao";
    }

    @RequestMapping(value = "/page_base_staff",method = RequestMethod.GET)
    public String findStaff(){
        return "base/staff";
    }

    @RequestMapping(value = "/page_base_region",method = RequestMethod.GET)
    public String findRegion(){
        return "base/region";
    }
    @RequestMapping(value = "/page_base_decidedzone",method = RequestMethod.GET)
    public String finddecidedzone(){
        return "base/decidedzone";
    }
    @RequestMapping(value = "/page_base_subarea",method = RequestMethod.GET)
    public String findsubarea(){
        return "base/subarea";
    }
    @RequestMapping(value = "/page_qupai_noticebill_add",method = RequestMethod.GET)
    public String findNoticebill(){
        return "qupai/noticebill_add";
    }
    @RequestMapping(value = "/page_qupai_quickworkorder",method = RequestMethod.GET)
    public String findQuickworkorder(){
        return "qupai/quickworkorder";
    }
    @RequestMapping(value = "/page_qupai_workorderimport",method = RequestMethod.GET)
    public String findWorkorderimport(){
        return "qupai/workorderimport";
    }
    @RequestMapping(value = "/page_qupai_diaodu",method = RequestMethod.GET)
    public String findDiaodu(){
        return "qupai/diaodu";
    }




}
