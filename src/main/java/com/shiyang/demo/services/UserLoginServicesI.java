package com.shiyang.demo.services;

import com.shiyang.demo.pojo.UserLogin;

import java.util.List;

public interface UserLoginServicesI {
    //查询
    public List<UserLogin> queryAll();
    //添加数据
    public int add(UserLogin userLogin);
    //根据用户名查询数据
    public UserLogin queryByName(String username);
}

