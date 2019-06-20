package com.qf.j1902.service.Impl;

import com.qf.j1902.mapper.QtMapper;
import com.qf.j1902.service.QtService;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
@Service
public class QtServiceImpl implements QtService {
    @Resource
    private QtMapper qtMapper;
    //查询用户信息
    @Override
    public List<User> denglu() {
        List<User> denglu = qtMapper.denglu();
        return denglu;
    }
    //登陆验证
    @Override
    public User findOne(HashMap map) {
        User user = qtMapper.findOne(map);
        return user;
    }
    //添加用户
    @Override
    public int add(String username, String password, String email, String idnumber) {
        int jg = qtMapper.add(username, password, email,idnumber);
        return jg;
    }
    //添加审核信息
    @Override
    public int addRz(UserInfo userInfo) {
        int Rzjg = qtMapper.addRz(userInfo);
        return Rzjg;
    }

    @Override
    public String getmessageByname(String uname) {
        String ZT = qtMapper.getmessageByname(uname);
        return ZT;
    }
}
