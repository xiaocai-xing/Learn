package com.example.demo.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Login {
    private int id;
    private String username;
    private String userpassword;

    @Basic
    @Column(name = "username")
    public String getUsername(){
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "userpassword")
    public String getUserpassword(){
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null||getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(username,login.username)&&Objects.equals(userpassword,login.userpassword);
    }

    @Override
    public int hashCode(){
        return Objects.hash(username,userpassword);
    }

    @Id
    @Column(name = "id")
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
}
