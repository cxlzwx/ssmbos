package com.it.bos.controller;/**
 * Created by Think on 2018/5/8.
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.it.bos.pojo.BcStaff;
import com.it.bos.vo.Page;
import com.it.bos.service.StaffService;
import com.it.bos.utils.StaffUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StaffAction
 * @Description 取派员action
 * @Author Think
 * @Date 2018/5/8 17:37
 * @Version 1.0
 */
@Controller
@RequestMapping("/json")
public class StaffAction {

    @Autowired
    private StaffService staffService;

    @RequestMapping(value = "/staffAll")
    @ResponseBody
    public Map<String, Object> findAll(Page page, Model model){
        PageHelper.startPage(Integer.valueOf(page.getPage()),Integer.valueOf(page.getRows()));
        List<BcStaff> staffs = staffService.findAll();
        int total = staffService.findCount();
        PageInfo<BcStaff> pageInfo = new PageInfo<>(staffs);
        HashMap<String, Object> map = new HashMap<>();
        map.put("total",total);
        map.put("rows",pageInfo.getList());
        return map;
    }

    @RequestMapping("/staffAdd")
    public void addStaff(BcStaff bcStaff){
        //生成staffId
        String id = StaffUUID.getUUID();
        bcStaff.setId(id);
        staffService.addStaff(bcStaff);
    }

}
