package com.qf.j1902.mapper;

import com.qf.j1902.mapper.HtMapper;
import com.qf.j1902.mapper.QtMapper;
import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/28.
 */
public class TestHtMapper {
    @Test
    public void addOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        int one = bean.addOne("sss", "qqq", "傻啊你", "170@qq.com");
        System.out.println(one);
    }
    @Test
    public void findAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        QtMapper bean = applicationContext.getBean(QtMapper.class);
        List<User> denglu = bean.denglu();
        System.out.println(denglu);

    }
    @Test
    public void delete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        int shanchu = bean.shanchu(12);
        System.out.println(shanchu);
    }
    @Test
    public void getUserById(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        User userById = bean.getUserById(5);
        System.out.println(userById);
    }

    @Test
    public void update(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        User user = new User();
        user.setId(4);
        user.setEmail("555");
        user.setUsername("sdsf");
        int update = bean.update(user);
        System.out.println(update);
    }

    @Test
    public void text3(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        List<UserInfo> all = bean.findAll();
        System.out.println(all);
    }

    @Test
    public void text4(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        HtMapper bean = applicationContext.getBean(HtMapper.class);
        int i = bean.deleteOne(5);
        System.out.println(i);
    }
}
