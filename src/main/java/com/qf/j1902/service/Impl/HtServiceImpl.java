package com.qf.j1902.service.Impl;

import com.qf.j1902.mapper.HtMapper;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import com.qf.j1902.service.HtService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
@Service
public class HtServiceImpl implements HtService {
    @Resource
    private HtMapper htMapper;
    @Override
    public int addOne(String username, String password, String email, String yhname) {
        int addOne = htMapper.addOne(username,password,email,yhname);
        return addOne;
    }

    @Override
    public int update(User user) {
        int update = htMapper.update(user);
        return update;
    }

    @Override
    public int shanchu(int id) {
        int shanchu = htMapper.shanchu(id);
        return shanchu;

    }

    @Override
    public User getUserById(int id) {
        User user = htMapper.getUserById(id);
        return user;
    }

    @Override
    public List<UserInfo> findAll() {
        List<UserInfo> userInfos = htMapper.findAll();
        return userInfos;
    }

    @Override
    public int deleteOne(int id) {
        int i = htMapper.deleteOne(id);
        return i;
    }
}
