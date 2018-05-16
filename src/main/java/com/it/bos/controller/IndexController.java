package com.it.bos.controller;/**
 * Created by Think on 2018/5/7.
 */

import com.it.bos.pojo.TUser;
import com.it.bos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description 首页登录controller
 * @Author Think
 * @Date 2018/5/7 1:38
 * @Version 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userservice;

    @RequestMapping("/")
    public String  loginPage(){
        return "login";
    }
    /**  
     * 
     * @Description 登录控制器
     * @date 2018/5/7 18:49  
     * @param [tUser, checkcode, session, model]  
     * @return java.lang.String  
     */
    @RequestMapping(value = "/page_common_index",method = RequestMethod.POST)
    public String loginIndex(
            TUser tUser, @RequestParam("checkcode") String checkcode, HttpSession session, RedirectAttributes redirectAttributes){
        String s_checkcode = (String) session.getAttribute("key");
        if(!"".equals(checkcode.trim()) && s_checkcode.equals(checkcode)){
            //验证码正确
            TUser user = userservice.userLoginByUsernameAndPassword(tUser.getUsername(),tUser.getPassword());
            if(!StringUtils.isEmpty(user)){
                session.setAttribute("user",user);
                return "common/index";
            }else {
                redirectAttributes.addAttribute("error","账号或密码错误");
                return  "forward:/";
            }
        }
        redirectAttributes.addAttribute("error","验证码错误");
        return "forward:/";
    }
    /**
     *
     * @Description 完成用户名的异步校验
     * @date 2018/5/7 18:52
     * @param [username]
     * @return com.it.bos.pojo.TUser
     */
    @RequestMapping(value ="/validateUsername",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> validateUsername(String username){
        TUser user = userservice.findByUsername(username);
        Map<String, String> map = new HashMap<>();
        if(user == null){
            //用户名不存在
            map.put("validateUsernameMSG","该用户不能登录");
        }else{
            //用户名存在
            map.put("validateUsernameMSG","该用户可以登录");
        }
        return map;
    }
}
