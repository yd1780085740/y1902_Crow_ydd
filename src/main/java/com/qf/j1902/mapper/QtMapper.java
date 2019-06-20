package com.qf.j1902.mapper;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
public interface QtMapper {
    //查询用户信息
    public List<User> denglu();
    //根据条件查询用户信息
    public User findOne(HashMap map);
    //注册用户
    public int add(@Param("username") String username,@Param("password") String password,@Param("email") String email,@Param("idnumber") String idnumber);
    //添加认证信息
    public int addRz(UserInfo userInfo);
    //根据用户名查询认证状态
    public String getmessageByname(String uname);
}
