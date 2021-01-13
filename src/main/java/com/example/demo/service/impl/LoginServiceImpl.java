package com.example.demo.service.impl;


import com.example.demo.entity.Login;
import com.example.demo.repository.MyRepository;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
    @Autowired
    MyRepository loginRepository;

    @Override
    public List<Login> findALL(){
        return null;
    }
    //登录
    @Override
    public List<Login>findByusernameAnduserpassword(String username,String userpassword){
        return loginRepository.findByUsernameAndUserpassword(username,userpassword);
    }
    //注册
    @Override
    public void save(Login login){
        loginRepository.save(login);
    }
    //查用户
    @Override
    public List<Login> findByUsername(String username){
        return loginRepository.findByUsername(username);
    }


}
