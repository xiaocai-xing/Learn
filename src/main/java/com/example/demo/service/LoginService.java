package com.example.demo.service;

import com.example.demo.entity.Login;

import java.util.List;

public interface LoginService {
    List<Login> findALL();
    List<Login> findByusernameAnduserpassword(String username,String userpassword);
    void save(Login login);
    List<Login> findByUsername(String username);
}
