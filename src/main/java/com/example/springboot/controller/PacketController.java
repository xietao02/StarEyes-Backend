package com.example.springboot.controller;

import com.example.springboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class PacketController {
    @Autowired
    private UserDao userDao;



}
