package com.qf.j1902.service;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;

import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
public interface HtService {
    //添加用户
    public int addOne(String username, String password, String email, String yhname);
    //根据id修改用户
    public int update(User user);
    //删除用户
    public int shanchu(int id);
    //根据ID查询用户
    public User getUserById(int id);
    //查询用户认证信息
    public List<UserInfo> findAll();
    //根据id删除用户认证信息
    public int deleteOne(int id);
}
