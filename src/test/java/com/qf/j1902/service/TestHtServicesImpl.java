package com.qf.j1902.service;

import com.qf.j1902.pojo.User;
import com.qf.j1902.pojo.UserInfo;
import com.qf.j1902.service.Impl.HtServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/28.
 */
public class TestHtServicesImpl {
    @Test
    public void addOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        HtServiceImpl bean = applicationContext.getBean(HtServiceImpl.class);
        int i = bean.addOne("yh", "hy", "xiaobai", "123@.com");
        System.out.println(i);
    }
    @Test
    public void update(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        HtServiceImpl bean = applicationContext.getBean(HtServiceImpl.class);
        User userById = bean.getUserById(13);
        System.out.println(userById);
    }
   /* @Test
    public void update2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
        HtServiceImpl bean = applicationContext.getBean(HtServiceImpl.class);
        int update = bean.update(4, "gg", "tt", "oxifjbtne");
        System.out.println();
    }*/
   @Test
    public void test(){
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-mybatis.xml","spring-service.xml");
       HtServiceImpl bean = applicationContext.getBean(HtServiceImpl.class);
       List<UserInfo> all = bean.findAll();
       System.out.println(all);
   }

}
