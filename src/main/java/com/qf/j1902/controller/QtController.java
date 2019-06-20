package com.qf.j1902.controller;

import com.qf.j1902.pojo.User;
import com.qf.j1902.service.QtService;
import com.qf.j1902.pojo.UserInfo;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 苏沐挽余寄笙歌 on 2019/5/27.
 */
@Controller
public class QtController {
    @Autowired
    private QtService service;

    //首页
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    //登陆页面
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    //注册
    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    // 后台管理跳转
    @RequestMapping("/main")
    public String main() {
        return "/main";
    }

    //跳转前台
   /* @RequestMapping("/member")
    public String member(){
        return "member";
    }*/

    //发送验证码
    @RequestMapping(value = "sendyzm",method = RequestMethod.POST)
    @ResponseBody
    public String yxyz(HttpServletRequest request, @RequestParam(defaultValue ="a" ) String exam){
        String regEx1 ="^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(regEx1);
        Matcher m = p.matcher(exam);
        if(m.matches()){
            try {
                HtmlEmail htmlEmail=new HtmlEmail();
                htmlEmail.setHostName("smtp.qq.com");
                htmlEmail.setCharset("utf-8");
                htmlEmail.addTo(exam);
                htmlEmail.setFrom("1780085740@qq.com","众筹系统");
                htmlEmail.setAuthentication("1780085740@qq.com","kycfkiwozfsqdbac");
                htmlEmail.setSubject("实名认证验证码");
                int a=(int)((Math.random()*9+1)*100000);
                String aa=String.valueOf(a);
                HttpSession session=request.getSession();
                session.setAttribute("SessionKey",aa);
                htmlEmail.setMsg("尊贵的会员：您的验证码为"+"<h3>"+aa+"</h3>");
                htmlEmail.send();
            } catch (EmailException e) {
                e.printStackTrace();
            }

            return "ok";
        }else {
            return "gg";
        }



    }

    //验证验证码跳转首页
    @RequestMapping("apply-4")
    public ModelAndView apply4(@RequestParam("username") String user,@RequestParam("uname") String uname, HttpSession session){
        System.out.println("apply4=========="+user);
        session.setAttribute("renzhengname",user);
        String ZT = service.getmessageByname(uname);
        session.setAttribute("state",ZT);
        return new ModelAndView("member");
    }
    //上传信息4(信息上传)
    @RequestMapping("apply-3")
    public ModelAndView apply3(UserInfo userInfo){
        String photo = userInfo.getPhoto();
        System.out.println("-------------"+photo);
        System.out.println(userInfo);
        int jg = service.addRz(userInfo);
        System.out.println(jg);
        return new ModelAndView("apply-3","userInfo",userInfo);
    }

    //上传信息3
    @RequestMapping(value="apply-2")
    public String upload(@RequestParam("tupian") MultipartFile mf, @RequestParam("classify") String calssify,
                        @RequestParam("idcard") String idcard, @RequestParam("phonen") String phonenumb,
                        @RequestParam("uname") String uname, Model model, HttpServletRequest request){
        System.out.println(mf);
        String path = request.getRealPath("upload");
        String fileName = mf.getOriginalFilename();
        String location = path + fileName;
        File f = new File(location);
        try {
            f.createNewFile();
            mf.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.addAttribute("classify",calssify);
        model.addAttribute("idcard",idcard);
        model.addAttribute("phonenumb",phonenumb);
        model.addAttribute("photo",fileName);
        model.addAttribute("uname",uname);

        /*UserInfo userInfo = new UserInfo();
        userInfo.setClassify(calssify);
        userInfo.setIdcard(idcard);
        userInfo.setPhonenumb(phonenumb);
        userInfo.setPhoto(fileName);
        userInfo.setUname(uname);
        System.out.println("----apply-2-------"+userInfo);*/
        return "apply-2";
    }

    //上传信息3
    @RequestMapping("apply-2")
    public ModelAndView apply2(UserInfo userInfo){
        ModelAndView mav = new ModelAndView("apply-2");
        mav.addObject("userInfo",userInfo);
        return mav;
    }

    //上传信息2
    @RequestMapping("apply-1")
    public ModelAndView apply1(UserInfo userInfo){
        ModelAndView mav = new ModelAndView("apply-1");
        mav.addObject("userInfo",userInfo);
        return mav;
    }

    //上传信息
    @RequestMapping("/apply")
    public ModelAndView apply(@RequestParam("lx")String lx){

        System.out.println(lx);
        String leixing = null;
        if("gs".equals(lx)){
           leixing="GongSi";
        }else if ("gt".equals(lx)){
            leixing = "GeTi";
        }else if ("gr".equals(lx)){
            leixing = "GeRen";
        }else if ("zf".equals(lx)){
            leixing = "ZhengFu";
        }
        return new ModelAndView("apply","leixing",leixing);
    }

    //跳转认证页面
    @RequestMapping("accttype")
    public String accttype(){

        return "accttype";
    }
    //用户管理页面
    @RequestMapping("/user")
    public ModelAndView user() {
        ModelAndView mv = new ModelAndView();
        List<User> denglu = service.denglu();
        mv.setViewName("/user");
        mv.addObject("users",denglu);
        return mv;
    }

    //判断登陆
    @RequestMapping(value = "/servlet", method = RequestMethod.POST)
    @ResponseBody
    public String denglu(String username, String password, String indetity,HttpSession session) {
        List<User> users = service.denglu();
        HashMap<String,Object> map= new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("indetity",indetity);
        User user = service.findOne(map);
        if(user==null) {
            return "kong";
        }else if(users.contains(user) && user.getIdnumber().equals("会员") && indetity.equals("会员")){
            session.setAttribute("user",user);
            return "qt";
        }else if(users.contains(user) && user.getIdnumber().equals("管理") && indetity.equals("管理")){
            session.setAttribute("user",user);
            return "ht";
        }
        return "qx";
    }

    //注册用户
    @RequestMapping(value = "/zhuce",method = RequestMethod.POST)
    @ResponseBody
    public String zhuce(String username, String password, String email,String idnumber){
        String zc = null;
        int jg = service.add(username, password, email, idnumber);
        if (jg!=0){
            return zc = "ok";
        }
        return zc;
    }

    //跳回上一步1
    @RequestMapping("shangyibu1")
    public ModelAndView shangyibu1(@RequestParam("") String classify,
                                   @RequestParam("") String idcard,
                                   @RequestParam("") String phonenumb,
                                   @RequestParam("") String uname){
        ModelAndView mav = new ModelAndView("apply");
        mav.addObject("classify",classify);
        mav.addObject("idcard",idcard);
        mav.addObject("phonenumb",classify);
        mav.addObject("uname",uname);
        return  mav;
    }
}