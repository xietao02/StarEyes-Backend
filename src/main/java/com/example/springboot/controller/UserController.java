package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import com.example.springboot.entity.User;
import com.example.springboot.util.TimeChecker;
import com.example.springboot.util.TokenProcessor;
import com.example.springboot.common.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//注解
@RestController
public class UserController {
    @Autowired
    private UserDao userDao;

    @PostMapping(value = "/login")
    public User login(@RequestBody User user) {
        if (user.getId() == null || user.getPassword() == null) {
            throw new RuntimeException("error:前端用户名或密码为空");
        } else {
            User result = userDao.loginByID(user.getId(), user.getPassword());
            if (result == null) {
                user.setId("-1");
            } else {
                TokenProcessor newToken = new TokenProcessor();
                String token = newToken.makeToken();
                user.setToken(token);
                userDao.saveToken(user.getId(), user.getToken());

                TimeChecker timeCheck = new TimeChecker();
                String expTime = timeCheck.getExpirationtime();
                userDao.saveExpTime(user.getId(), expTime);
            }
            return user;
        }
    }

    @PostMapping(value = "/api/auth/verify")
    public boolean verify(@RequestBody User user) {
        String token = userDao.getToken(user.getId());
        String expTime = userDao.gerExpTime(user.getId());
        return new Authorization().verify(user, token, expTime);
    }

}
