package com.qf.j1902.mapper;

import com.qf.j1902.pojo.User;
import com.qf.j1902.service.Impl.QtServiceImpl;
import com.qf.j1902.pojo.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/28.
 */

public class TestQtMapper {
    @Test
   public void Testall(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        QtServiceImpl bean = applicationContext.getBean(QtServiceImpl.class);
        List<User> denglu = bean.denglu();
        for (User user:denglu){
            System.out.println(user);
        }
    }
    @Test
    public void TestfindOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        QtMapper bean = applicationContext.getBean(QtMapper.class);
        Map<String, Object> map = new HashMap<>();
        User user = new User("qq","ww");
       String username = user.getUsername();
       String password = user.getPassword();
       map.put("username",username);
       map.put("password",password);
        User one = bean.findOne((HashMap) map);
        System.out.println(one);
    }

    @Test
    public void add(){
        int id = 0;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        QtMapper bean = applicationContext.getBean(QtMapper.class);
        int jg = bean.add("ww", "ee", "123@.com", "会员");
        System.out.println(jg);
    }

    @Test
    public void addRz(){
        int id = 0;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        QtMapper bean = applicationContext.getBean(QtMapper.class);
        UserInfo userInfo = new UserInfo("GeTi","ujn","tfv","sedcxsd","IMG_20180228_105422_HHT.jpg","1780085740@qq.com");
        int addRz = bean.addRz(userInfo);
        System.out.println(addRz);
    }

    @Test
    public void text(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        QtMapper bean = applicationContext.getBean(QtMapper.class);
        String ujn = bean.getmessageByname("ujn");
        System.out.println(ujn);
    }
}
