package com.example.demo.controller;


import com.example.demo.entity.Login;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ResponseBody
@RestController
public class MyController {
    @Autowired
    LoginService loginService;
    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    @RequestMapping("/registers")
    public ModelAndView zhuce(){
        ModelAndView mv = new ModelAndView("register");
        return mv;
    }

    @RequestMapping("/fanhui")
    public ModelAndView fanhui(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    //登录功能
    @PostMapping("/login")
    public ModelAndView Login(@RequestParam(value = "username") String username,@RequestParam(value = "userpassword")String userpassword){
        List<Login> login = loginService.findByusernameAnduserpassword(username,userpassword);
//        for (Login l:loginService.findALL()){
//            System.out.println(l.getUsername()+":"+l.getUserpassword());
//        }
//        System.out.println(username+":"+userpassword);
        System.out.println(login);
        ModelAndView success = new ModelAndView();
        if (login.size()>0){
            success.setViewName("success");
        }else {
            success.setViewName("404");
        }
        return success;
    }

    //登录功能
//    public  String LoginMod(HttpServletRequest request ){
//        String username = request.getParameter("username");
//        String userpassword = request.getParameter("userpassword");
//        Map<String, String> umap = new HashMap<String,String>();
//        umap.put("username1",username);
//        umap.put("userpassword1",userpassword);
//        List<Login> login = loginService.findByusernameAnduserpassword(username,userpassword);
//        if ()
//    }

    //注册功能

    @PostMapping("/register")
    public ModelAndView register(@RequestParam("username") String username,@RequestParam("password")
            String password,@RequestParam("password2") String password2){
        ModelAndView success = new ModelAndView();
        //用户或密码为空的条件判断
        if(username.isEmpty()||password.isEmpty()||password2.isEmpty()){
            success.setViewName("register");
            success.addObject("tip1","用户或密码不能为空");
            return success;
        }
        //两次密码不一样的判断条件
        if(!password.equals(password2)){
            success.setViewName("register");
            success.addObject("tip2","两次密码不一样");
            return success;
        }
        //判断是否取到用户，如果没有就保存在数据库中
        List<Login> us=loginService.findByUsername(username);
        if(us.size()==0){
            //List<Login> register=loginService.save(username,password);
            Login registers=new Login();
            registers.setUserpassword(password);
            registers.setUsername(username);
            loginService.save(registers);
            success.setViewName("success");
        }
        else {
            success.setViewName("404");
        }
        return success;
    }
}
