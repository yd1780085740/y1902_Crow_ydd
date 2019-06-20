package com.qf.j1902.mapper;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
public interface HtMapper {
    //添加用户
    public int addOne(@Param("username") String username,@Param("password") String password,@Param("yhname") String yhname,@Param("email") String email);
    //根据id修改用户
    public int update(User user);
    //删除用户
    public int shanchu(int id);
    //根据id查询用户信息
    public User getUserById(int id);
    //查询用户认证信息
    public List<UserInfo> findAll();
    //根据id删除用户认证信息
    public int deleteOne(int id);

}
