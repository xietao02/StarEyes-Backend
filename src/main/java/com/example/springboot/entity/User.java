package com.example.springboot.entity;


import lombok.Data;

@Data
public class User {
    private String id;
    private String password;
    private String token;
}
