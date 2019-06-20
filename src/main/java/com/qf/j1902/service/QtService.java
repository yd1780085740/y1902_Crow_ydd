package com.qf.j1902.service;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
public interface QtService {
    //查询用户信息
    public List<User> denglu();
    //根据条件查询用户信息
    public User findOne(HashMap map);
    //注册用户
    public int add(String username,String password,String email,String idnumber);
    //添加认证信息
    public int addRz(UserInfo userInfo);
    //查询当前用户认证状态
    public String getmessageByname(String uname);
}
