package com.sxy.nsh;

public interface UserService {
boolean login();
boolean login(String username,String password);
boolean register(User user);
boolean updatePass(int uid,String newpass);
}
