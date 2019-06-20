package com.qf.j1902.controller;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import com.qf.j1902.service.HtService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
@Controller
public class HtController {
    @Autowired
    private HtService htService;
    //修改页面
    @RequestMapping("/edit")
    public ModelAndView edit(int id){
        User user = htService.getUserById(id);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("edit");
        mv.addObject("user",user);
        return mv;
    }
    //
    @RequestMapping("assignRole")
    public String tiaozhuan(){
        return "assignRole";
    }
    //新增页面
    @RequestMapping("/add")
    public String add(){
        return "/add";
    }
    //新增用户
    @RequestMapping("/addOne")
    @ResponseBody
    public String addOne(String username, String email, String yhname){
        String password = "123";
        int one = htService.addOne(username, password, email, yhname);
        if(one==1){
            return "ok";
        }
        return "gg";
    }
    //修改用户信息
    @RequestMapping(value = "/xiugai",method = RequestMethod.POST)
    @ResponseBody
    public String xiugai(@Param("id") int editid , User user){
        user.setId(editid);
        int update = htService.update(user);
        String s = String.valueOf(update);
        return s;
    }
    //删除用户
    @RequestMapping("/shanchu")
    @ResponseBody
    public String delete(int id){
        ModelAndView mv = new ModelAndView();
        int shanchu = htService.shanchu(id);
        if(shanchu == 1){
            return "ok";
        }
        return "gg";
    }

    //实名认证
    @RequestMapping("auth_cert")
    public ModelAndView renzheng(){
        List<UserInfo> userInfo = htService.findAll();
        System.out.println(userInfo);
        return new ModelAndView("auth_cert","userInfo",userInfo);
    }

    //认证信息删除
    @RequestMapping("rzxg")
    @ResponseBody
    public String shenhe(int id){
        int i = htService.deleteOne(id);
        System.out.println(i);
        if (i == 1){
            return "ok";
        }else {
            return "gg";
        }
    }
}
